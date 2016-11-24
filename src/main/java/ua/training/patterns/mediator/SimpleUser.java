package ua.training.patterns.mediator;

/**
 * <p> The Admin class.
 * This class implements User interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
class SimpleUser implements User{
    private Chat chat;

    public SimpleUser(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("User receives message '" + message + "'");
    }
}