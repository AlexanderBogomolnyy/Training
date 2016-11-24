package ua.training.patterns.mediator.complicated;
/**
 * <p> The Admin class.
 * This class extends User abstract class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
class SimpleUser extends User{
    private Chat chat;

    public SimpleUser(Chat chat, String name) {
        super(chat, name);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("User " + getName() + " receives message '" + message + "'");
    }
}