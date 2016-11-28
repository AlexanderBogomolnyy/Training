package ua.training.patterns.templatemethod;

/**
 * <p> The Template Method pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 28.11.2016.
 */
public class TemplateMethodApp {
    public static void main(String[] args) {
        C a = new A();
        a.templateMethod();

        System.out.println();

        C b = new B();
        b.templateMethod();
    }
}
