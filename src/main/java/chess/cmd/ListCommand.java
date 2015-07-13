package chess.cmd;

import java.util.Map;

import chess.GameState;
import chess.Position;
import chess.pieces.Piece;

/**
 * List all the possible moves
 */
public class ListCommand implements Command<String> {

    @Override
    public String execute(GameState gameState) {
        Map<Position, Piece> positions = gameState.getCurrentPlayerPositions();
        StringBuilder sb = new StringBuilder();
        for(Position position : positions.keySet()) {
            Piece piece = positions.get(position);
            for(Position possibleMove : piece.findMoves(position, gameState)) {
                sb.append("\t").append(position)
                        .append(" ")
                        .append(possibleMove)
                        .append("\n");
            }
        }
        return sb.toString();
    }
}
