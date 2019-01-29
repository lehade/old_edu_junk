package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 24.01.2019
 */

public class TrackerSingleLaLo {

    private TrackerSingleLaLo() {
    }

    public static TrackerSingleLaLo getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerSingleLaLo INSTANCE = new TrackerSingleLaLo();
    }

    public static void main(String[] args) {
        TrackerSingleLaLo tracker = TrackerSingleLaLo.getInstance();
    }

}