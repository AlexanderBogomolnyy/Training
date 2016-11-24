package ua.training.patterns.mediator;

/**
 * <p> The User interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
interface User {
    void sendMessage(String message);
    void getMessage(String message);
}
