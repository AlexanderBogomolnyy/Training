package ua.training.patterns.mediator;

/**
 * <p> The Mediator pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
public class MediatorApp {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        User admin = new Admin(chat);
        User u1 = new SimpleUser(chat);
        User u2 = new SimpleUser(chat);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);

        u1.sendMessage("Hello, I am user.");
        admin.sendMessage("Admin has joined the chat!!!");

    }
}
