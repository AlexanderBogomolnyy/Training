package ua.training.patterns.state;

/**
 * <p> The class imitates some human behaviour.
 * This is a Context class from State pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 25.11.2016.
 */
class Human {
    private Activity state;

    public void setState(Activity state) {
        this.state = state;
    }

    public void doSomething() {
        state.doSomething(this);
    }
}
