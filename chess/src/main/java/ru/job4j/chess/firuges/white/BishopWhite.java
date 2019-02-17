package ru.job4j.chess.firuges.white;

import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite extends Figure {

    public BishopWhite(final Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        int move = source.x - dest.x;
        boolean trueMove = false;
        if ((source.y == dest.y + move && source.x == dest.x + move)
                || (source.y == dest.y - move && source.x == dest.x + move)) {
            steps = new Cell[]{dest};
            trueMove = true;
        }
        if (!trueMove) {
            throw new ImpossibleMoveException();
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
