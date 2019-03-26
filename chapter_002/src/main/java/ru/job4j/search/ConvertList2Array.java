package ru.job4j.search;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 24.03.2019
 */

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size() / (double) rows);
        int[][] array = new int[rows][cells];
        int cell = 0;
        int row = 0;
        for (int i : list) {
            if (cell == cells) {
                row++;
                cell = 0;
            }
            array[row][cell++] = i;
        }
        return array;
    }
}