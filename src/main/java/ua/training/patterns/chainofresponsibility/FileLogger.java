package ua.training.patterns.chainofresponsibility;

/**
 * <p> The class extends abstract Logger and represents some File Logger behavior.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
class FileLogger extends Logger{

    public FileLogger(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Write to file: " + message);
    }

}
