package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.Logic;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.firuges.black.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.chess.firuges.Cell.*;

public class ChessTest {

    @Test
    public void FigureNotFoundExceptionTest() {
        Logic logic = new Logic();
        boolean thrown = false;
        logic.add(new PawnBlack(H7));
        try {
            logic.move(H6, H4);
        }
        catch (FigureNotFoundException e) {
            thrown = true;
        }
        assertThat(thrown, is(true));
    }

    @Test
    public void OccupiedWayExceptionTest() {
        Logic logic = new Logic();
        boolean thrown = false;
        logic.add(new BishopBlack(C8));
        logic.add(new PawnBlack(D7));
        try {
            logic.move(C8, E6);
        }
        catch (OccupiedWayException e) {
            thrown = true;
        }
        assertThat(thrown, is(true));
    }

    @Test
    public void ImpossibleMoveExceptionTest() {
        Logic logic = new Logic();
        boolean thrown = false;
        logic.add(new BishopBlack(C8));
        try {
            logic.move(C8, E7);
        }
        catch (ImpossibleMoveException e) {
            thrown = true;
        }
        assertThat(thrown, is(true));
    }

    @Test
    public void BishopMoveTest() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C8));
        boolean move = logic.move(C8, E6);
        assertThat(move, is(true));
    }

}