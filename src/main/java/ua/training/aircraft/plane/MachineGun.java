package ua.training.aircraft.plane;

/**
 * <p> The machine gun class.
 * This class represents some kind of machine gun
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public class MachineGun extends Armament {

	public MachineGun() {
		super();
	}

	public MachineGun(int ammunition) {
		super(ammunition);
	}

	@Override
	public ArmamentType getArmamentType() {
		return ArmamentType.MACHINE_GUN;
	}

}
