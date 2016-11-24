package ua.training.patterns.chainofresponsibility;

/**
 * <p> The class extends abstract Logger and represents some SMS Logger behavior.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
class SMSLogger extends Logger{

    public SMSLogger(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("SMS: " + message);
    }

}
