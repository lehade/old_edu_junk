package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 23.12.2018
 */

public class MaxTest {

    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(5, 9);
        assertThat(result, is(9));
    }
    @Test
    public void whenMaxIntFromThree() {
        Max maxim = new Max();
        int result = maxim.max(15, 19, 16);
        assertThat(result, is(19));
    }

}
