package ua.training.forester.multipleaction;

/**
 * <p> The Forester activity interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public interface Activity {
    /**
     * This method returns event for current action
     *
     * @return - event
     */
    Event getEvent();

    /**
     * This method runs some action of forester
     */
    void doAction();
}
