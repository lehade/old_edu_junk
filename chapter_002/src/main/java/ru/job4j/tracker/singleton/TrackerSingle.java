package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

/**
 * Private static final class. Lazy loading.
 * @author Alexey Denisenko
 * @version 0.1
 * @since 30.01.2019
 */

public class TrackerSingle {

    private TrackerSingle() {
    }

    public static TrackerSingle getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingle INSTANCE = new TrackerSingle();
    }

    public static void main(String[] args) {
        TrackerSingle tracker = TrackerSingle.getInstance();
    }
}