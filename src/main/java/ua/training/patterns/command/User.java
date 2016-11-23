package ua.training.patterns.command;

/**
 * <p> The class represents user which works with some computer.
 * This is Invoker class for Command pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
class User {
    Command start;
    Command stop;
    Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComputer() {
        start.execute();
    }

    void stopComputer() {
        stop.execute();
    }

    void resetComputer() {
        reset.execute();
    }
}
