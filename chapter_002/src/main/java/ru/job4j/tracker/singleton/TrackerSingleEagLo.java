package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

/**
 * Singleton class eager loading
 * @author Alexey Denisenko
 * @version 0.1
 * @since 30.01.2019
 */

public class TrackerSingleEagLo {
    private static final TrackerSingleEagLo INSTANCE = new TrackerSingleEagLo();

    private TrackerSingleEagLo() {
    }

    public static TrackerSingleEagLo getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerSingleEagLo tracker = TrackerSingleEagLo.getInstance();
    }
}