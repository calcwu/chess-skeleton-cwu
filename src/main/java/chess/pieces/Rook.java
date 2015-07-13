package chess.pieces;

import java.util.Set;

import chess.GameState;
import chess.GameStateMoveValidator;
import chess.Player;
import chess.Position;
import com.gs.collections.impl.factory.Sets;

/**
 * The 'Rook' class
 */
public class Rook extends Piece {

    public Rook(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'r';
    }

    @Override
    protected Set<Position> doFindPositions(Position position, GameState gameState) {
        GameStateMoveValidator gsm = new GameStateMoveValidator(gameState);
        return Sets.mutable
                .withAll(gsm.findVerticalMoves(getOwner(), position))
                .withAll(gsm.findHorizontalMoves(getOwner(), position));
    }
}
