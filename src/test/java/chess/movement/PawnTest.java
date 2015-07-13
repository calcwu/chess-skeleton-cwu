package chess.movement;

import java.util.Set;

import chess.GameState;
import chess.Position;
import chess.Positions;
import chess.pieces.Piece;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 */
public class PawnTest {

    @Test
    public void test() {
        GameState gameState = new GameState();
        gameState.reset();

        Position position = Positions.at("a2");
        Piece piece = gameState.getPieceAt(position);
        Set<Position> positionSet = piece.findMoves(position, gameState);
        assertEquals(2, positionSet.size());
        assertTrue(positionSet.contains(Positions.at("a3")));
        assertTrue(positionSet.contains(Positions.at("a4")));
    }

}
