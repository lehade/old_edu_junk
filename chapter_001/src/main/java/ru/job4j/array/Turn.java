package ru.job4j.array;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 27.12.2018
 */

public class Turn {
    public int[] back(int[] array) {
        int temp;
        for (int index = 0; index < array.length / 2; index++) {
            temp = array[array.length - index - 1];
            array[array.length - index - 1] = array[index];
            array[index] = temp;
        }
        return array;
    }
}