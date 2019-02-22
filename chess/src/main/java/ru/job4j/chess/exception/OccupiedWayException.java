package ru.job4j.chess.exception;


public class OccupiedWayException extends RuntimeException {

    public OccupiedWayException() {
        System.out.println("Occupied Way!");
    }

}