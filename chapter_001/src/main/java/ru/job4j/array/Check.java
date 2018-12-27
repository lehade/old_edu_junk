package ru.job4j.array;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 27.12.2018
 */

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int i = 0; i < data.length; i++) {
            if (i == 0) continue;
            if (data[i] == data[i - 1]) {
                result = true;
            }
        }
        return result;
    }
}