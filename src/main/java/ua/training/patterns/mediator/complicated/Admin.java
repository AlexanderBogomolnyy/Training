package ua.training.patterns.mediator.complicated;

/**
 * <p> The Admin class.
 * This class extends User abstract class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
class Admin extends User{

    public Admin(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("Admin " + getName() + " receives message '" + message + "'");
    }
}

