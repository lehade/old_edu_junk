package ru.job4j.professions;

/**
 * @author Alexey Denisenko
 * @version 0.1
 * @since 05.01.2019
 */

public class Doctor extends Profession {

    public Doctor(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public void curePatient(Patient patient) {

    }
}