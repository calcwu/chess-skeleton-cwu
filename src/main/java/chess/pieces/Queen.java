package chess.pieces;

import java.util.Set;

import chess.GameState;
import chess.GameStateMoveValidator;
import chess.Player;
import chess.Position;
import com.gs.collections.impl.factory.Sets;

/**
 * The Queen
 */
public class Queen extends Piece {
    public Queen(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'q';
    }

    @Override
    protected Set<Position> doFindPositions(Position position, GameState gameState) {
        GameStateMoveValidator gsm = new GameStateMoveValidator(gameState);
        return Sets.mutable
                .withAll(gsm.findHorizentalMoves(getOwner(), position))
                .withAll(gsm.findVerticalMoves(getOwner(), position))
                .withAll(gsm.findInclineDiagonalMoves(getOwner(), position))
                .withAll(gsm.findDeclineDiagonalMoves(getOwner(), position))
        ;
    }

}
