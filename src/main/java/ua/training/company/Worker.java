package ua.training.company;

/**
 * <p> The Worker interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 16.12.2016.
 */
public interface Worker {

    /**
     * This method changed worker position for some other one
     *
     * @param toPosition - new position
     * @param successors - some successors for subordinate, if necessary
     * @return true, if employee have been changed
     */
    boolean changePosition(Position toPosition, Employee... successors);

}
