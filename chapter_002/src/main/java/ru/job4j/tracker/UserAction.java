package ru.job4j.tracker;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 10.01.2019
 */

public interface UserAction {

    int key();

    void execute(Input input, Tracker tracker);

    String info();

}