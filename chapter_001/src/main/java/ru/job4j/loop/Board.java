package ru.job4j.loop;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 24.12.2018
 */

public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 1) {
                    screen.append(' ');
                } else {
                    screen.append('X');
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}