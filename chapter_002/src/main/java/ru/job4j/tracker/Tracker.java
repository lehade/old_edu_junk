package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 06.01.2019
 */

public class Tracker {

    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Добавляем заявку
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Заменяем заявку
     */
    public boolean replace(String id, Item item) {
        boolean replace = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                items[i].setId(id);
                replace = true;
                break;
            }
        }
        return replace;
    }

    /**
     * Удаляем заявку
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - i - 1);
                this.position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Вывод всех заявок
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Поиск заявок по имени
     */
    public Item[] findByName(String key) {
        Item[] temp = new Item[this.position];
        int count = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                temp[count++] = this.items[i];
            }
        }
        Item[] listOfNames = Arrays.copyOf(temp, count);
        return listOfNames;
    }

    /**
     * Поиск заявок по id
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Генерация id заявки
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }


}