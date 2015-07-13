package chess.pieces;

import java.util.Set;

import chess.GameState;
import chess.Player;
import chess.Position;
import chess.movement.Moves;
import com.gs.collections.impl.factory.Sets;

/**
 * The Knight class
 */
public class Knight extends Piece {
    public Knight(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'n';
    }

    @Override
    protected Set<Position> doFindPositions(Position position, GameState gameState) {
        //if knight is located at d4
        return Sets.mutable.with(
                Moves.move(getOwner(), position, 1, 2), //e6
                Moves.move(getOwner(), position, 2, 1), //f5
                Moves.move(getOwner(), position, 2, -1), //f3
                Moves.move(getOwner(), position, 1, -2), //e2
                Moves.move(getOwner(), position, -2, 1), //b5
                Moves.move(getOwner(), position, -1, 2), //c6
                Moves.move(getOwner(), position, -2, -1), //b3
                Moves.move(getOwner(), position, -1, -2) //c2
        );
    }

}
