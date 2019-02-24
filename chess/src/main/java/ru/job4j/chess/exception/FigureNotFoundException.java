package ru.job4j.chess.exception;


public class FigureNotFoundException extends RuntimeException {

    public FigureNotFoundException() {
        System.out.println("The figure is not found!");
    }

}