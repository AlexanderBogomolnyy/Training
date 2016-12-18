package ua.training.aircraft.plane;

/**
 * <p> The airplane activity class.
 * This class force airplane to land on
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public class LandOn implements Action {
    @Override
    public void act(MilitaryPlane plane) {
        if (plane.inAir) {
            plane.inAir = false;
            System.out.println("Airplane is landing on.");
        } else {
            System.out.println("Airplane already on the ground.");
        }
    }
}
