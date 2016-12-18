package ua.training.aircraft.plane;

/**
 * <p> The Action interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public interface Action {

    /**
     * This method provides some kind of actions on the plane
     *
     * @param plane - some military plane
     */
    void act(MilitaryPlane plane);
}
