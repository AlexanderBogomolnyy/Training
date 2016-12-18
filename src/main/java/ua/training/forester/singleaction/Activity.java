package ua.training.forester.singleaction;

/**
 * <p> The Forester activity interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public interface Activity {

    /**
     * This method runs some action of forester
     *
     * @param forester - current forester
     */
    void doAction(Forester forester);
}
