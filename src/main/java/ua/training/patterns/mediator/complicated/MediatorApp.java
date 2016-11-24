package ua.training.patterns.mediator.complicated;

/**
 * <p> The Mediator pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
public class MediatorApp {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        User admin = new Admin(chat, "Jone Dou");
        User u1 = new SimpleUser(chat, "Jack");
        User u2 = new SimpleUser(chat, "Bill");
        User u3 = new SimpleUser(chat, "Sandy");
        u2.setEnable(false);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);
        chat.addUser(u3);

        u1.sendMessage("Hello!");
        admin.sendMessage("Admin has joined the chat!!!");

    }
}