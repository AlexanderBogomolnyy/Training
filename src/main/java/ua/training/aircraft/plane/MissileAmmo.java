package ua.training.aircraft.plane;

/**
 * <p> The missile ammo class.
 * This class represents some kind of missile ammo
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public class MissileAmmo extends Armament {

	public MissileAmmo() {
		super();
	}

	public MissileAmmo(int ammunition) {
		super(ammunition);
	}

	@Override
	public ArmamentType getArmamentType() {
		return ArmamentType.MISSILE_AMMO;
	}

}
