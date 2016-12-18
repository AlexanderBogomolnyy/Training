package ua.training.aircraft.plane;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> The military plane class.
 * This class represents some kind of military plane
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public class MilitaryPlane {

    /**
     * This field shows is plane in air
     */
    boolean inAir = false;

    /**
     * The map of plane armament
     */
    private Map<ArmamentType, Armament> armaments = new HashMap<>();

    /**
     * Current action for the plane
     */
    private Action action;

    /**
     * This method adds armament to the plane list of armament
     *
     * @param armamentType - armament type
     * @param amount - initial ammunition capacity
     * @return true if armament added
     */
    public boolean addArmament(ArmamentType armamentType, int amount) {
        if (checkInAir()) {
            return false;
        }
        if (amount < 0) {
            System.out.println("Illegal amount of ammunition!");
            return false;
        }
        if (armaments.containsKey(armamentType)) {
            System.out.println("This type of armament already added.");
            return false;
        }
        switch (armamentType) {
            case MACHINE_GUN:
                armaments.put(armamentType, new MachineGun(amount));
                break;
            case MISSILE_AMMO:
                armaments.put(armamentType, new MissileAmmo(amount));
                break;
            default:
                throw new IllegalArgumentException("Unsupported type of armament.");
        }
        return true;
    }

    // this method checks is plane in air
    private boolean checkInAir() {
        if (inAir) {
            System.out.println("You can not do any manipulation with armament in air.");
            return true;
        }
        return false;
    }

    /**
     * This method removes armament from the plane list of armament
     *
     * @param armamentType - armament type
     * @return - true if armament have been removed
     */
    public boolean removeArmament(ArmamentType armamentType) {
        return !checkInAir() && armaments.remove(armamentType) != null;
    }

    /**
     * This method returns armament of selected type from plane list of armament of null if it is absent
     *
     * @param armamentType - armament type
     * @return armament from the plane list of armament or null if it is absent
     */
    public Armament getArmament(ArmamentType armamentType) {
        if (armaments.containsKey(armamentType)) {
            return armaments.get(armamentType);
        }
        System.out.println("Sorry. No any " + armamentType.getName() + " here!!!");
        return null;
    }

    /**
     * This method adds ammunition to the armament from plane list of armament
     * @param type - armament type
     * @param amountOfAmmunition - amount of ammunition
     * @return true if ammunition have been added
     */
    public boolean addAmmunition(ArmamentType type, int amountOfAmmunition) {
        if(checkInAir()) {
            return false;
        }
        Armament armament = getArmament(type);
        if (armament != null) {
            int ammunition = armament.getAmmunition();
            armament.setAmmunition(ammunition + amountOfAmmunition);
            return true;
        }
        return false;
    }

    /**
     * This method returns current plane state (fly/land)
     * @return true if plain is in air, false in opposite case
     */
    public boolean isInAir() {
        return inAir;
    }

    /**
     * This method sets current plane action
     *
     * @param action - action
     */
    public void setAction(Action action) {
        this.action = action;
    }

    /**
     * This method execute current plane action
     */
    public void action() {
        if (action == null) {
            System.out.println("Please set an action.");
        } else {
            action.act(this);
        }
    }
}
