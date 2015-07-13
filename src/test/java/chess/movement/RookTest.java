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
public class RookTest {

    @Test
    public void test() {
        GameState gameState = new GameState();
        gameState.reset();

        Position position = Positions.at("a1");
        Piece piece = gameState.getPieceAt(position);
        Set<Position> positionSet = piece.findMoves(position, gameState);
        assertEquals(0, positionSet.size());

        Position a2 = Positions.at("a2");

        //move a2 out of the way to test Rook moves
        gameState.move(gameState.getPieceAt(position), a2, Positions.at("b4"));

        positionSet = piece.findMoves(position, gameState);
        assertEquals(5, positionSet.size());
        for(int i=2; i<7; i++) {
            assertTrue(positionSet.contains(Positions.at("a" + i)));
        }
    }

}
