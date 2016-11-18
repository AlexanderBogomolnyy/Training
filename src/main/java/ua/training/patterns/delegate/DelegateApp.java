package ua.training.patterns.delegate;

/**
 * <p> The Delegate pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
public class DelegateApp {
    public static void main(String[] args) {
        B b = new B();
        b.f();

        System.out.println("\n---== Another Sample (Painter & Graphics) ==---\n");

        Painter painter = new Painter();

        painter.setGraphics(new Square());
        painter.draw();

        painter.setGraphics(new Triangle());
        painter.draw();

        painter.setGraphics(new Circle());
        painter.draw();
    }
}
