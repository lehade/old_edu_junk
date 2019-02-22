package ru.job4j.chess.exception;


public class ImpossibleMoveException extends RuntimeException {

    public ImpossibleMoveException() {
        System.out.println("Impossible move!");
    }

}