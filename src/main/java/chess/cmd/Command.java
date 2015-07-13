package chess.cmd;

import chess.GameState;

/**
 *
 */
public interface Command<O> {

    /**
     * Generic Command that takes GameState and returns arbitrary type depending on the
     * nature of the command
     *
     * @param gameState
     * @return O
     */
    O execute(GameState gameState);
}
