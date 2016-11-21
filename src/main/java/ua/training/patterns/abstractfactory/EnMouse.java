package ua.training.patterns.abstractfactory;

/**
 * <p> The class implements Mouse device behavior for English location.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 21.11.2016.
 */
public class EnMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Mouse click");
    }

    @Override
    public void doubleClick() {
        System.out.println("Mouse double click");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Scroll Up");
        } else if (direction < 0) {
            System.out.println("Scroll Down");
        } else {
            System.out.println("No scrolling");
        }
    }
}
