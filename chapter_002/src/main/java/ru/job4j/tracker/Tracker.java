package ru.job4j.tracker;

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

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean replace = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                replace = true;
                break;
            }
        }
        return replace;
    }

    public boolean delete(String id) {

        boolean result = false;
        int pos;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                pos = i;
                System.arraycopy(this.items, pos + 1, this.items, pos, this.items.length - pos - 1);
                this.items[this.position--] = null;
                result = true;
            }
        }
        return result;
    }

    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] temp = new Item[this.position];
        int count = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                temp[count++] = this.items[i];
            }
        }
        Item[] listOfNames = new Item[count];
        for (int index = 0; index < count; index++) {
            listOfNames[index] = temp[index];
        }
        return listOfNames;
    }

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

    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }


}