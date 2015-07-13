package chess;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Basic Unit Tests for the PositionBuilder class
 */
public class PositionsTest {

    @Test
    public void test() {
        assertEquals(Position.MAX_ROW * Position.MAX_ROW, Positions.all().size());

        assertNotNull(Positions.at("a1"));
        assertNotNull(Positions.at("h1"));
        assertNotNull(Positions.at('a', 1));

        assertNotNull(Positions.at("a8"));
        assertNotNull(Positions.at("h8"));
        assertNotNull(Positions.at('h', 8));

        assertEquals(Positions.at("a9"), Positions.OUT_OF_POSITION);
    }

}
