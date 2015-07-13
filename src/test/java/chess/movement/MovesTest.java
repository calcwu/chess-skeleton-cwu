package chess.movement;

import chess.Player;
import chess.Position;
import chess.Positions;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *
 */
public class MovesTest {

    @Test
    public void test() {

        Position position = Positions.at("a2");
        assertEquals("a4", Moves.forward(Player.White, position, 2).getId());
        assertEquals("d5", Moves.move(Player.White, position, 3, 3).getId());
        assertFalse(Positions.isValid(Moves.forward(Player.Black, position, 2)));

        assertEquals("a7", Moves.forward(Player.Black, Positions.at("a8"), 1).getId());
    }
}
