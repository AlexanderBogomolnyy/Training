package ua.training.patterns.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> The Text Chat class.
 * This class imitates specific Mediator from Mediator pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
class TextChat implements Chat {
    private User admin;
    private List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void sendMessage(String message, User user){
        for(User u: users) {
            u.getMessage(message);
        }
        admin.getMessage(message);
    }
}
