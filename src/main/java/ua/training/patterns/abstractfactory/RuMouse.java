package ua.training.patterns.abstractfactory;

/**
 * <p> The class implements Mouse device behavior for Russian location.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 21.11.2016.
 */
public class RuMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Щелчок мышью");
    }

    @Override
    public void doubleClick() {
        System.out.println("Двойной щелчок мышью");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Скроллим вверх");
        } else if (direction < 0) {
            System.out.println("Скроллим вниз");
        } else {
            System.out.println("Не скроллим");
        }
    }
}
