package chess;

import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class GameStateMoveValidatorTest {

    @Test
    public void testInclineDiagonal() {
        GameState gameState = new GameState();
        Position p = Positions.at("d5");
        GameStateMoveValidator gsm = new GameStateMoveValidator(gameState);
        Set<Position> positionSet = gsm.findInclineDiagonalMoves(Player.White, p);
        assertEquals(6, positionSet.size());
    }

    @Test
    public void testDeclineDiagonal() {
        GameState gameState = new GameState();
        Position p = Positions.at("d5");
        GameStateMoveValidator gsm = new GameStateMoveValidator(gameState);
        Set<Position> positionSet = gsm.findDeclineDiagonalMoves(Player.White, p);
        assertEquals(7, positionSet.size());
    }

}
