package ua.training.aircraft.plane;

/**
 * <p> The Armament abstract class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public abstract class Armament {

	/**
	 * This field contains amount of armament ammunition
	 */
	private int ammunition = 0;
	
	public Armament() {
	}
		
	public Armament(int ammunition) {
		this.ammunition = ammunition;
	}

	public int getAmmunition() {
		return ammunition;
	}

	public void setAmmunition(int ammunition) {
		this.ammunition = ammunition;
	}

	/**
	 * This method provides imitation of armament soot
	 *
	 * @param numberOf - number of spent ammo
	 * @return true, if such kind of shoot is possible
	 */
	protected boolean shoot(int numberOf) {
		String armamentName = getArmamentType().getName();
		System.out.println("This is " + armamentName + ".");
		if (numberOf <= ammunition) {
			System.out.println("WOW! " + armamentName + " shoot!!!!");
			ammunition -= numberOf;
			return true;
		} else {
			System.out.println("Oops! " + armamentName + " doesn't have enough ammunition! Sorry!");
			return false;
		}
	}

	/**
	 * This method returns type of armament
	 * @return - type of armament
	 */
	public abstract ArmamentType getArmamentType();
	
}
