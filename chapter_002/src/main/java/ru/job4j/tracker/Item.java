package ru.job4j.tracker;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 06.01.2019
 */

public class Item {

    private String id;
    public String name;
    public String description;
    public long create;
    public String comments;

    public Item() {

    }
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getCreate() {
        return create;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}