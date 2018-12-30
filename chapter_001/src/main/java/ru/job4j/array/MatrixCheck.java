package ru.job4j.array;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 30.12.2018
 */

public class MatrixCheck {

    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = data.length - 1; i > 0; i--) {
            if (data[0][i] != data[i][i]) {
                result = false;
                break;
            }
        }
        for (int i = 0; i < data.length; i++) {
            if (data[0][0] != data[i][i]) {
                result = false;
                break;
            }
        }
        return result;
    }

}