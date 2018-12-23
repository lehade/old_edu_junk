package ru.job4j.max;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 23.12.2018
 */

public class Max {

    public int max(int first, int second, int third) {
        //int temp = this.max(first, second);
        //int maxT = this.max(temp, third);
        return this.max(this.max(first, second), third);
    }

    public int max(int first, int second) {
        int max = first > second ? first : second;
        return max;
    }

}