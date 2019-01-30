package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

/**
 * Class for singleton lazy loading
 * @author Alexey Denisenko
 * @version 0.1
 * @since 30.01.2019
 */

public class TrackerSingleLaLo {

    private static TrackerSingleLaLo instance;

    private TrackerSingleLaLo() {
    }

    public static TrackerSingleLaLo getInstance() {
        if (instance == null) {
            instance = new TrackerSingleLaLo();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }

}