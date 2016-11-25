package ua.training.patterns.observer;

/**
 * <p> The Observer interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 25.11.2016.
 */
interface Observer {
    void handleEvent(int temperature, int presser); //4. Observer can only receive message, but not send
}
