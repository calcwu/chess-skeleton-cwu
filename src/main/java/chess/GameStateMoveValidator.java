package chess;

import java.util.Set;

import chess.movement.Moves;
import com.gs.collections.impl.factory.Sets;

/**
 *
 * GameStateMoveValidate - find list of possible sequential moves.
 *
 */
public class GameStateMoveValidator {

    enum Axis {
        x, y
    }

    private GameState gameState;

    public GameStateMoveValidator(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * find a set of sequential moves along y axis
     * @param player
     * @param position
     * @return
     */
    public Set<Position> findVerticalMoves(Player player, Position position) {
        return findXYMoves(player, position, Axis.y);
    }

    /**
     * find a set of sequential moves along x axis
     * @param player
     * @param position
     * @return
     */
    public Set<Position> findHorizentalMoves(Player player, Position position) {
        return findXYMoves(player, position, Axis.x);
    }

    /**
     *
     * find / validate all possible moves along x and y axis.
     *
     * @param player
     * @param position
     * @return
     */
    private Set<Position> findXYMoves(Player player, Position position, Axis type) {
        //check x axis sequentially
        Set<Position> positions = Sets.mutable.of();
        int max = Position.MAX_ROW, min = 0, start=1;
        switch(type) {
            case x:
                max = Position.MAX_COLUMN;
                min = 'a';
                start = position.getColumn(); break;
            case y:
                start = position.getRow(); break;
        }
        Position p = position;
        for(int i = start; i<=max; i++) {
            p = Axis.x.equals(type)? Moves.right(player, p, 1) : Moves.forward(player, p, 1);
            if(!addIfValid(positions, p)) {
                break;
            }
        }
        p = position;
        for(int i = start; i>=min; i--) {
            p = Axis.x.equals(type)? Moves.left(player, p, 1) : Moves.backward(player, p, 1);
            if(!addIfValid(positions, p)) {
                break;
            }
        }
        return positions;
    }

    /**
     *
     * @param player
     * @param position
     * @return
     */
    public Set<Position> findInclineDiagonalMoves(Player player, Position position) {
        Set<Position> positions = Sets.mutable.of();
        //cover right / up diagonal
        for(int i=position.getRow(), y=1, x=1; i<=Position.MAX_ROW; i++, y++, x++) {
            Position p = Moves.move(player, position, x, y);
            if(!addIfValid(positions, p)) {
                break;
            }
        }
        //cover left / down diagonal
        for(int i=position.getRow(), y=-1, x=-1; i>0; i--, y--, x--) {
            Position p = Moves.move(player, position, x, y);
            if(!addIfValid(positions, p)) {
                break;
            }
        }
        return positions;
    }

    /**
     *
     * @param player
     * @param position
     * @return
     */
    public Set<Position> findDeclineDiagonalMoves(Player player, Position position) {
        Set<Position> positions = Sets.mutable.of();
        //cover left / up diagonal
        for(int i=position.getRow(), y=1, x=-1; i<=Position.MAX_ROW; i++, y++, x--) {
            Position p = Moves.move(player, position, x, y);
            if(!addIfValid(positions, p)) {
                break;
            }
        }
        //cover right / down diagonal
        for(int i=position.getRow(), y=-1, x=1; i>0; i--, y--, x++) {
            Position p = Moves.move(player, position, x, y);
            if(!addIfValid(positions, p)) {
                break;
            }
        }
        return positions;
    }

    /**
     * Add to set if the position is either a valid move or is occupied by the other player
     * @param set
     * @param position
     * @return
     */
    private boolean addIfValid(Set<Position> set, Position position) {
        return gameState.isValidMoveOrOccupiedByOpponent(position)
                && set.add(position);
    }

}
