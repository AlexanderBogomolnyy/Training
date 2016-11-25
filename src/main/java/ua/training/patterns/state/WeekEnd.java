package ua.training.patterns.state;

/**
 * <p> The class imitates relax activity of human.
 * This class implements Activity interface.
 * This is a Concrete State class from State pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 25.11.2016.
 */
public class WeekEnd implements Activity {
    private int count = 0;
    @Override
    public void doSomething(Human context) {
        if (count < 3) {
            System.out.println("Rest & relax (Zzzz)");
            count++;
        } else {
            context.setState(new Work());
        }
    }
}
