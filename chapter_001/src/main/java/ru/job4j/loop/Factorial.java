package ru.job4j.loop;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 24.12.2018
 */

public class Factorial {
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
