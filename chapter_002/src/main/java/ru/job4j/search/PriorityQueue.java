package ru.job4j.search;

import java.util.LinkedList;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 16.03.2019
 */

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        //TODO добавить вставку в связанный список.
        int temp = tasks.size();
        if (tasks.size() > 0) {
            for (int i = 0; i < tasks.size(); i++) {
                if (task.getPriority() < tasks.get(i).getPriority()) {
                    temp = tasks.indexOf(tasks.get(i));
                    break;
                }
            }
        }
        this.tasks.add(temp, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
