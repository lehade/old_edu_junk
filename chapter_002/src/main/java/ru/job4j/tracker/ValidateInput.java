package ru.job4j.tracker;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 17.01.2019
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuException e) {
                System.out.println("Выберите значение из диапазона меню:");

            } catch (NumberFormatException e) {
                System.out.println("Выберите корректное действие из списка:");
            }

        }
        while (invalid);
        return value;
    }
}