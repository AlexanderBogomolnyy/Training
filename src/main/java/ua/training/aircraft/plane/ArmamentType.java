package ua.training.aircraft.plane;

/**
 * <p> The enum of types of armament.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public enum ArmamentType {
    MACHINE_GUN ("Machine gun"),
    MISSILE_AMMO ("Missile ammo");

    private String name;

    private ArmamentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
