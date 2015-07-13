package chess.movement;

import java.util.Set;

import chess.GameState;
import chess.Position;
import chess.Positions;
import chess.pieces.Piece;
import com.gs.collections.impl.factory.Sets;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 */
public class KnightTest {

    @Test
    public void test() {
        GameState gameState = new GameState();
        gameState.reset();

        Position position = Positions.at("b1");
        Piece piece = gameState.getPieceAt(position);
        Set<Position> positionSet = piece.findMoves(position, gameState);
        assertEquals(2, positionSet.size());
        assertEquals(0, Sets.difference(
                positionSet, Positions.at("a3", "c3")).size());

        Position a2 = Positions.at("a2");
        //move a2 forward to test knight moves
        gameState.move(gameState.getPieceAt(position), a2, Positions.at("a3"));

        positionSet = piece.findMoves(position, gameState);
        assertEquals(1, positionSet.size());
        assertTrue(positionSet.contains(Positions.at("c3")));
    }

}
