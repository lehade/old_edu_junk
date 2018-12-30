package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 30.12.2018
 */

public class ArrayDuplicate {

    public String[] removeDuplicates(String[] array) {
        int duplicate = array.length;
        for (int i = 0; i < duplicate; i++) {
            for (int j = i + 1; j < duplicate; j++) {
                if (array[i].equals(array[j])) {
                    array[j] =  array[duplicate - 1];
                    duplicate--;
                    j--;
                }
            }
        }
        return Arrays.copyOf(array, duplicate);
    }

}