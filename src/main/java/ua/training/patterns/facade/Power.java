package ua.training.patterns.facade;

/**
 * <p> This class represents model of computer power supply.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
class Power {
    void on() {
        System.out.println("Switch on.");
    }
    void off() {
        System.out.println("Switch off.");
    }
}
