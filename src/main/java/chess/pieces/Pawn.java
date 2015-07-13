package chess.pieces;

import java.util.Set;

import chess.GameState;
import chess.Player;
import chess.Position;
import chess.movement.Moves;
import com.gs.collections.api.block.predicate.Predicate;
import com.gs.collections.impl.factory.Sets;

/**
 * The Pawn
 */
public class Pawn extends Piece {

    public Pawn(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'p';
    }

    @Override
    protected Set<Position> doFindPositions(Position position, final GameState gameState) {
        Set<Position> forwardMoves = Sets.mutable.of(
                Moves.forward(getOwner(), position, 1)
        );
        //add 2 space ahead only if this is the first move
        if( (position.getRow() == 2 && getOwner().equals(Player.White))
                || (position.getRow() == 7 && getOwner().equals(Player.Black))) {
            forwardMoves.add(Moves.forward(getOwner(), position, 2));
        }

        //the following are only valid moves if it's occupied by opponents.
        return Sets.mutable.of(
                Moves.move(getOwner(), position, -1, 1),
                Moves.move(getOwner(), position, 1, 1)
        ).select(new Predicate<Position>() {
            @Override
            public boolean accept(Position position) {
                return gameState.isOccupiedByOpponent(position);
            }
        }).withAll(forwardMoves); //add everything else from first set
    }
}