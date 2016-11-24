package ua.training.patterns.chainofresponsibility;

/**
 * <p> The abstract class describes Logger and common behaviour for all loggers.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
abstract class Logger {

    /**
     * Logger priority
     */
    private int priority;

    /**
     * Next Logger in chain
     */
    private Logger next;

    Logger(int priority) {
        this.priority = priority;
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    /**
     * This method writs log if parameter level less or equals to logger priority,
     * in other way calls next logger in logger chain if it exists.
     *
     * @param message - text message
     * @param level - logger level
     */
    public void writeMessage(String message, int level) {
        if (level <= priority) {
            write(message);
        }
        if(next != null) {
            next.writeMessage(message, level);
        }
    }

    /**
     * This abstract method have to write message
     *
     * @param message - text message
     */
    abstract void write(String message);
}
