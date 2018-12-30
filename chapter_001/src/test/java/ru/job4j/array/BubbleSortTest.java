package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 30.12.2018
 */

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        bubbleSort.sort(array);
        //int[] array = bubbleSort.calculate(bound);
        int[] expect = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(array, is(expect));
    }

    @Test
    public void whenSortArrayWithTenElementsThenSortedArray1to9() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {6, 9, 4, 2, 3, 1, 7, 8, 0, 5};
        bubbleSort.sort(array);
        //int[] array = bubbleSort.calculate(bound);
        int[] expect = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(array, is(expect));
    }
}