package ru.job4j.array;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 27.12.2018
 */

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1;
         for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}