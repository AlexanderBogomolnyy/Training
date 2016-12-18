package ua.training.aircraft.plane;

/**
 * <p> The airplane activity class.
 * This class force airplane to shoot
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public class Shoot implements Action {

    /**
     * The number of ammo in one shoot
     */
    private int numberOfShots = 0;

    /**
     * The kind of armament
     */
    private ArmamentType type;

    public Shoot(ArmamentType type, int numberOfShots) {
        this.type = type;
        this.numberOfShots = numberOfShots;
    }

    @Override
    public void act(MilitaryPlane plane) {
        if (plane.isInAir()) {
            if (plane.getArmament(type) != null) {
                boolean shootResult = plane.getArmament(type).shoot(numberOfShots);
                if (shootResult) {
                    System.out.println("Nice shot!");
                } else {
                    System.out.println("Time to start worrying! Something goes wrong!");
                }
            } else {
                System.out.println("Oh my GOD! Select correct armament at first!");
            }
        } else {
            System.out.println("It is impossible to fight on the earth! Let's fly up at first!");
        }

    }

}
