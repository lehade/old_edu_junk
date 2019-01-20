package ru.job4j.tracker;

import java.util.Scanner;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 07.01.2019
 */

public class ConsoleInput implements Input {
    Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuException("Выбор вне значений меню.");
        }
        return key;
    }
}