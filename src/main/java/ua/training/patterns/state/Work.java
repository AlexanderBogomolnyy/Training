package ua.training.patterns.state;

/**
 * <p> The class imitates work activity of human .
 * This class implements Activity interface.
 * This is a Concrete State class from State pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 25.11.2016.
 */
class Work implements Activity{
    @Override
    public void doSomething(Human context) {
        System.out.println("Let's work \u270D \u270D \u270D \u270D");
        context.setState(new WeekEnd());
    }
}
