package ru.job4j.tracker;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 06.01.2019
 */

public class StartUI {

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Task("First task", "First desc"));
        for (Item item : tracker.findAll()) {
            System.out.println(item.getName());
        }

    }

}