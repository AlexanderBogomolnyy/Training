package ua.training.company;

/**
 * <p> The Other employee interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 16.12.2016.
 */
public interface Other {

    /**
     * This method sets employee description
     *
     * @param description - employee description
     */
    void setDescription(String description);

    /**
     * This method returns description of other employee
     *
     * @return - employee description
     */
    String getDescription();

    /**
     * This method changed other employee position for some other one
     *
     * @param toPosition - new position
     * @param successors - some successors for subordinate, if necessary
     * @return true, if employee have been changed
     */
    boolean changePosition(Position toPosition, Employee... successors);
}
