package ru.job4j.array;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 26.12.2018
 */

public class Square {

    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < rst.length; i++) {
            rst[i] = (int) Math.pow((i+1), 2);
        }
        return rst;
    }
}