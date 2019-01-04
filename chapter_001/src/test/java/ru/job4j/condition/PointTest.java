package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void pointTest() {

        Point a = new Point(10, 5);
        Point b = new Point(-3, -3);
        double result = a.distanceTo(b);
        double expected = 15.264337522473747;
        assertThat(result, is(expected));

    }
}