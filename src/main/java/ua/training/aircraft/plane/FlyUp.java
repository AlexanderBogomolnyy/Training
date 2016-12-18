package ua.training.aircraft.plane;

/**
 * <p> The airplane activity class.
 * This class force airplane to fly up
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public class FlyUp implements Action {
    @Override
    public void act(MilitaryPlane plane) {
        if (plane.inAir) {
            System.out.println("Airplane already in air!");
        } else {
            plane.inAir = true;
            System.out.println("Airplane is flying up.");
        }
    }
}
