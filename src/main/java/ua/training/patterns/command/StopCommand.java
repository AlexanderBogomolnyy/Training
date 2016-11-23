package ua.training.patterns.command;

/**
 * <p> The class represents stopping of computer.
 * This is ConcreteCommand class for Command pattern idiom.
 * This class implements Command interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
class StopCommand implements Command {

    Computer computer;

    public StopCommand(Computer computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.stop();
    }
}
