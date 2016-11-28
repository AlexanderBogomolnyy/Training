package ua.training.patterns.templatemethod;

/**
 * <p> Some kind of abstract class.
 * This class contains template method
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 28.11.2016.
 */
abstract class C {
    void templateMethod() {
        System.out.print("1");
        differ();
        System.out.print("3");
        differ2();
    }

    abstract void differ();
    abstract void differ2();
}
