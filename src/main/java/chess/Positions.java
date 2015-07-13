package chess;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.gs.collections.impl.factory.Maps;
import com.gs.collections.impl.factory.Sets;

/**
 *
 * Positions - cached all positions
 *
 */
public enum Positions {
    ;

    private static final Map<String, Position> POSITION_MAP = Maps.mutable.of();

    public static final Position OUT_OF_POSITION = new Position('z', -1);

    static {
        for(int i=1; i<=Position.MAX_ROW; i++) {
            for(char c = 'a'; c<='h'; c++) {
                Position p = new Position(c, i);
                POSITION_MAP.put(p.toString(), new Position(c, i));
            }
        }
    }

    /**
     * Look up a Position object by string
     * @param colrow The column and row to use.  I.e. "a1", "h7", etc.
     */
    public static Position at(String colrow) {
        Position p = POSITION_MAP.get(colrow);
        if(p == null) {
            p = OUT_OF_POSITION;
        }
        return p;
    }

    /**
     * Look up a Position object by column and row
     *
     * @param column
     * @param row
     * @return Position
     */
    public static Position at(char column, int row) {
        return at(String.valueOf(column) + String.valueOf(row));
    }

    /**
     * get a set of positions
     *
     * @param colrows
     * @return
     */
    public static Set<Position> at(String... colrows) {
        Set<Position> set = Sets.mutable.of();
        for(String colrow : colrows) {
            Position p = at(colrow);
            if(isValid(p)) {
                set.add(p);
            }
        }
        return set;
    }
    /**
     *
     * @return all positions
     */
    public static Collection<Position> all() {
        return POSITION_MAP.values();
    }

    /**
     * check if a position is valid, not out of bound.
     *
     * @param position
     * @return
     */
    public static boolean isValid(Position position) {
        return position!=null && !position.equals(OUT_OF_POSITION);
    }
}
