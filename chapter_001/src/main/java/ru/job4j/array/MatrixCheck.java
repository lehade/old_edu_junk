package ru.job4j.array;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 30.12.2018
 */

public class MatrixCheck {

    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if (data[0][0] != data[i][i] || data[data.length - i - 1][i] != data[i][data.length - i - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}