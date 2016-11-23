package ua.training.patterns.command;

/**
 * <p> The class represents some behavior of computer.
 * This is Receiver class for Command pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
class Computer {
    void start() {
        System.out.println("Start");
    }
    void stop() {
        System.out.println("Stop");
    }
    void reset() {
        System.out.println("Reset");
    }
}
