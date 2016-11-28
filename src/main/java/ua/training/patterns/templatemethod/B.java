package ua.training.patterns.templatemethod;

/**
 * <p> Some class extends abstract class C, which contains template method.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 28.11.2016.
 */
class B extends C {
    @Override
    void differ() {
        System.out.print("4");
    }

    @Override
    void differ2() {
    }
}
