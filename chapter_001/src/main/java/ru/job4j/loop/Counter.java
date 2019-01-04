package ru.job4j.loop;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 24.12.2018
 */

public class Counter {
    public int add(int start, int finish) {
        int temp = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                temp += i;
            }
        }
        return temp;
    }
}