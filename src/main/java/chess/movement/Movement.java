package chess.movement;

import java.util.Set;

import chess.GameState;
import chess.Position;

/**
 *  Defines individual moving pattern
 */
public interface Movement {

    /**
     *
     * @param position
     * @param gameState
     * @return a set of valid moves
     */
    Set<Position> findMoves(Position position, GameState gameState);
}
