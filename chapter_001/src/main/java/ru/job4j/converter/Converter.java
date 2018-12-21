package ru.job4j.converter;

/**
 * Корвертор валюты.
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return 70 / value;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return 60 / value;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return Рубли.
     */
    public int euroToRub(int value) {
        return value * 70;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли
     */
    public int dollarToRub(int value) {
        return value * 60;
    }
}