package ru.job4j.shapes;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 08.01.2019
 */

public class Triangle implements Shape {

    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("    +    ");
        pic.append("  + + +  ");
        pic.append("+ + + + +");
        return pic.toString();
    }

}