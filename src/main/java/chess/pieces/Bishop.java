package chess.pieces;

import java.util.Set;

import chess.GameState;
import chess.GameStateMoveValidator;
import chess.Player;
import chess.Position;
import com.gs.collections.impl.factory.Sets;

/**
 * The 'Bishop' class
 */
public class Bishop extends Piece {
    public Bishop(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'b';
    }

    @Override
    protected Set<Position> doFindPositions(Position position, GameState gameState) {
        GameStateMoveValidator gsm = new GameStateMoveValidator(gameState);
        return Sets.mutable
                .withAll(gsm.findInclineDiagonalMoves(getOwner(), position))
                .withAll(gsm.findDeclineDiagonalMoves(getOwner(), position));
    }
}
