package ua.training.patterns.delegate;

/**
 * <p> Some kind of class which calls method from another class
 * through it's object.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
class B {
    A a = new A();
    void f() {
        a.f();
    }
}
