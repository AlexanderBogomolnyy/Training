package ua.training.patterns.mediator.complicated;

/**
 * <p> The Chat interface.
 * This class imitates Mediator interface from Mediator pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
interface Chat {
    void sendMessage(String message, User user);
}
