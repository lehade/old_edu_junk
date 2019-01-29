package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import java.util.Random;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 24.01.2019
 */

public enum TrackerSingleEnum {
    INSTANCE;
    Tracker tracker = new Tracker();
    private static final Random RN = new Random();

    /**
     * Добавляем заявку
     */
    public Item add(Item item) {
        return this.tracker.add(item);
    }

    /**
     * Заменяем заявку
     */
    public boolean replace(String id, Item item) {
        return this.tracker.replace(id, item);
    }

    /**
     * Удаляем заявку
     */
    public boolean delete(String id) {
        return this.tracker.delete(id);
    }

    /**
     * Вывод всех заявок
     */
    public Item[] findAll() {
        return this.tracker.findAll();
    }

    /**
     * Поиск заявок по имени
     */
    public Item[] findByName(String key) {
        return this.tracker.findByName(key);
    }

    /**
     * Поиск заявок по id
     */
    public Item findById(String id) {
        return this.tracker.findById(id);
    }

    /**
     * Генерация id заявки
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
}