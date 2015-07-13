package chess.movement;


import chess.Player;
import chess.Position;
import chess.Positions;

/**
 * Define common move patterns.
 */
public enum Moves {

    ;

    /**
     * Move forward
     *
     * Forward is relative depends on the Player
     *
     * @param player
     * @param position
     * @param steps
     * @return
     */
    public static Position forward(Player player, Position position, int steps) {
        return move(player, position, 0, steps);
    }

    public static Position backward(Player player, Position position, int steps) {
        return move(player, position, 0, steps * -1);
    }

    public static Position left(Player player, Position position, int steps) {
        return move(player, position, steps * -1, 0);
    }

    public static Position right(Player player, Position position, int steps) {
        return move(player, position, steps, 0);
    }

    public static Position move(Player player, Position position, int x, int y) {
        int factor = Player.White.equals(player) ? 1 : -1;
        int newRow = position.getRow() + (y * factor);
        int column = position.getColumn() + x;
        return Positions.at((char) column, newRow);
    }
}
