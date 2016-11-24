package ua.training.patterns.mediator.complicated;

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
        if (admin != null && admin instanceof Admin){
            this.admin = admin;
        } else {
            throw new RuntimeException("Not enough permissions!");
        }

    }

    public void addUser(User user) {
        if (admin == null) {
            throw new RuntimeException("There is no admin in the chat!");
        }
        if (user instanceof SimpleUser) {
            users.add(user);
        } else {
            throw new RuntimeException("Admin can not enter into another chat!");
        }
    }

    public void sendMessage(String message, User user){
        if (user instanceof Admin) {
            for (User u : users) {
                u.getMessage(user.getName() + ": " + message);
            }
        }
        if (user instanceof SimpleUser) {
            for(User u: users) {
                if(u!=user && u.isEnable()) {
                    u.getMessage(user.getName() + ": " + message);
                }
            }
            if (admin.isEnable()) {
                admin.getMessage(user.getName() + ": " + message);
            }
        }
    }
}

