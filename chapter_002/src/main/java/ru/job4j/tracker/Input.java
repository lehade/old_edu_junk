package ru.job4j.tracker;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 07.01.2019
 */

public interface Input {

    String ask(String question);

    int ask(String question, int[] range);
}