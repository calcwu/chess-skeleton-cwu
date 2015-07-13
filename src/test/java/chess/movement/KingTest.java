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
 *
 */
public class KingTest {

    @Test
    public void test() {
        GameState gameState = new GameState();
        gameState.reset();

        Position position = Positions.at("e1");
        Piece piece = gameState.getPieceAt(position);
        Set<Position> positionSet = piece.findMoves(position, gameState);
        assertEquals(0, positionSet.size());

        Position e2 = Positions.at("e2");
        //move e2 out of the way to test King's move
        gameState.move(gameState.getPieceAt(position), e2, Positions.at("e4"));

        positionSet = piece.findMoves(position, gameState);
        assertEquals(1, positionSet.size());
        assertEquals(1, positionSet.size());
        assertTrue(positionSet.contains(Positions.at("e2")));
    }
}
