package ua.training.patterns.observer;

/**
 * <p> The class represents Console Observer and implements Observer interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 25.11.2016.
 */
public class ConsoleObserver implements Observer {
    @Override
    public void handleEvent(int temperature, int presser) {
        System.out.println("The weather has changed. Temperature = " + temperature + ", Presser = " + presser + ".");
    }
}
