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
}