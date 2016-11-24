package ua.training.patterns.chainofresponsibility;

/**
 * <p> The class extends abstract Logger and represents some e-mail Logger behavior.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
class EmailLogger extends Logger{

    public EmailLogger(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("E-mail message: " + message);
    }

}
