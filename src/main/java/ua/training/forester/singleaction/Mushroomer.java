package ua.training.forester.singleaction;

/**
 * <p> The Forester activity class.
 * This class force Forester to become a Mushroomer
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public class Mushroomer implements Activity {
    @Override
    public void doAction(Forester forester) {
        System.out.println("Let's collect mushrooms!!!!");
    }
}
