package ua.training.aircraft;

import ua.training.aircraft.plane.*;

/**
 * <p> The Runner class with main executive method.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public class PlaneApp {

    public static void main(String[] args) {
        MilitaryPlane plane = new MilitaryPlane();
        plane.setAction(new FlyUp());
        plane.addArmament(ArmamentType.MACHINE_GUN, 0);
        plane.addAmmunition(ArmamentType.MACHINE_GUN, 100);
        plane.addArmament(ArmamentType.MISSILE_AMMO, 10);
        plane.action();
        plane.setAction(new Shoot(ArmamentType.MACHINE_GUN, 12));
        plane.action();
        plane.setAction(new LandOn());
        plane.action();
    }

}
