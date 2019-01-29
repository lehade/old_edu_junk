package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerSingle {

    private static TrackerSingle instance;
    private Tracker tracker = new Tracker();

    private TrackerSingle() {
    }

    public static TrackerSingle getInstance() {
        if (instance == null) {
            instance = new TrackerSingle();
        }
        return instance;
    }

    public Item add(Item item) {
        return this.tracker.add(item);
    }

}