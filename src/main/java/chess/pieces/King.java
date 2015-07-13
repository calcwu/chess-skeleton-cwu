package chess.pieces;

import java.util.Set;

import chess.GameState;
import chess.Player;
import chess.Position;
import chess.movement.Moves;
import com.gs.collections.impl.factory.Sets;

/**
 * The King class
 */
public class King extends Piece {
    public King(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'k';
    }

    @Override
    protected Set<Position> doFindPositions(Position position, GameState gameState) {
        return Sets.mutable.with(
                Moves.forward(getOwner(), position, 1),
                Moves.backward(getOwner(), position, 1),
                Moves.left(getOwner(), position, 1),
                Moves.right(getOwner(), position, 1),
                Moves.move(getOwner(), position, 1, 1), //right top corner
                Moves.move(getOwner(), position, -1, 1), //left top corner
                Moves.move(getOwner(), position, 1, -1), //bottom right corner
                Moves.move(getOwner(), position, -1, -1) //bottom left corner
        );
    }
}
