package ua.training.patterns.chainofresponsibility;

/**
 * <p> The Chain of Responsibility pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
public class ChainOfResponsibilityApp {
    public static void main(String[] args) {
        Logger logger0 = new SMSLogger(Level.ERROR);
        Logger logger1 = new FileLogger(Level.DEBUG);
        Logger logger2 = new EmailLogger(Level.INFO);
        logger1.setNext(logger2);
        logger0.setNext(logger1);
        logger0.writeMessage("All right", Level.INFO);
        logger0.writeMessage("There is a debug mode", Level.DEBUG);
        logger0.writeMessage("The system fell down", Level.ERROR);
    }
}
