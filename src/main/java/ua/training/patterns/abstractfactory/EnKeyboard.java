package ua.training.patterns.abstractfactory;

/**
 * <p> The class implements Keyboard device behavior for English location.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 21.11.2016.
 */
public class EnKeyboard implements Keyboard{
    @Override
    public void print() {
        System.out.print("Print");
    }

    @Override
    public void println() {
        System.out.println("Print Line");
    }
}
