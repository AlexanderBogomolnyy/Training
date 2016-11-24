package ua.training.patterns.mediator.complicated;

/**
 * <p> The User abstract class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
abstract class User {
    private Chat chat;
    private String name;
    private boolean isEnable = true;

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public User (Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message){
        chat.sendMessage(message, this);
    }

    abstract void getMessage(String message);
}

