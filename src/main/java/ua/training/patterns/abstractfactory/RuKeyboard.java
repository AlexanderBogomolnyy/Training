package ua.training.patterns.abstractfactory;

/**
 * <p> The class implements Keyboard device behavior for Russian location.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 21.11.2016.
 */
public class RuKeyboard implements Keyboard{
    @Override
    public void print() {
        System.out.print("Печатаем строку");
    }

    @Override
    public void println() {
        System.out.println("Печатаем строку с переводом строки");
    }
}
