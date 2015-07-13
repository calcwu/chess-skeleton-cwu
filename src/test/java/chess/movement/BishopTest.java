package chess.movement;

import java.util.Set;

import chess.GameState;
import chess.Position;
import chess.Positions;
import chess.pieces.Piece;
import com.gs.collections.impl.factory.Sets;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class BishopTest {

    @Test
    public void test() {
        GameState gameState = new GameState();
        gameState.reset();

        Position position = Positions.at("f1");
        Piece piece = gameState.getPieceAt(position);
        Set<Position> positionSet = piece.findMoves(position, gameState);
        assertEquals(0, positionSet.size());

        Position e2 = Positions.at("e2");
        //move e2 out of the way to test bishop moves
        gameState.move(gameState.getPieceAt(position), e2, Positions.at("e4"));

        positionSet = piece.findMoves(position, gameState);
        assertEquals(5, positionSet.size());
        assertEquals(0, Sets.difference(
                positionSet, Positions.at("e2", "d3", "c4", "b5", "a6")).size());
    }
}
