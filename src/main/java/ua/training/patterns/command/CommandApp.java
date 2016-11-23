package ua.training.patterns.command;

/**
 * <p> The Command pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
public class CommandApp {

    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User(new StartCommand(computer), new StopCommand(computer), new ResetCommand(computer));
        user.startComputer();
        user.resetComputer();
        user.stopComputer();
    }

}
