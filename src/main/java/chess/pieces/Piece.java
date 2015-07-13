package chess.pieces;

import java.util.Set;

import chess.GameState;
import chess.Player;
import chess.Position;
import chess.movement.Movement;
import com.gs.collections.api.block.predicate.Predicate;
import com.gs.collections.impl.factory.Sets;

/**
 * A base class for chess pieces
 */
public abstract class Piece implements Movement {

    private final Player owner;

    protected Piece(Player owner) {
        this.owner = owner;
    }

    public char getIdentifier() {
        char id = getIdentifyingCharacter();
        if (owner.equals(Player.White)) {
            return Character.toLowerCase(id);
        } else {
            return Character.toUpperCase(id);
        }
    }

    public Player getOwner() {
        return owner;
    }

    protected abstract char getIdentifyingCharacter();

    @Override
    public Set<Position> findMoves(Position position, final GameState gameState) {
        return Sets.mutable
                .ofAll(doFindPositions(position, gameState))
                .select(new Predicate<Position>() {
                    @Override
                    public boolean accept(Position position) {
                        return gameState.isValidMove(position);
                    }
                });
    }

    protected Set<Position> doFindPositions(Position position, GameState gameState) {
        return Sets.mutable.empty();
    }

}
