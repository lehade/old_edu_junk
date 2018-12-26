package ru.job4j.loop;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 25.12.2018
 */

public class PaintTest {

    @Test
    public void whenPyramidIs4Right() {
        Paint paint = new Paint();
        String rst = paint.rightTrl(3);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("^  ")
                                .add("^^ ")
                                .add("^^^")
                                .toString()
                )
        );
    }

    @Test
    public void whenPyramidIs4Left() {
        Paint paint = new Paint();
        String rst = paint.leftTrl(3);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("  ^")
                                .add(" ^^")
                                .add("^^^")
                                .toString()
                )
        );
    }

    @Test
    public void whenPyramidIsThree() {
        Paint paint = new Paint();
        String rst = paint.pyramid(3);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("  ^  ")
                                .add(" ^^^ ")
                                .add("^^^^^")
                                .toString()
                )
        );
    }

    @Test
    public void whenPyramidIsTwo() {
        Paint paint = new Paint();
        String rst = paint.pyramid(2);
        assertThat(rst,
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add(" ^ ")
                                .add("^^^")
                                .toString()
                )
        );
    }
}
