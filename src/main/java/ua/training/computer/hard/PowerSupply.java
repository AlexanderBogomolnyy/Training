package ua.training.computer.hard;

/**
 * <p> This class represents model of computer power supply.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
class PowerSupply {
    /**
     * This method starts the computer and provides power supply for it
     */
    void on(Computer computer) {
        if (computer.isStarted) {
            System.out.println("Computer already switched on.");
        } else {
            System.out.println("Switch on.");
            computer.isStarted = true;
        }
    }

    /**
     * This method stops the computer
     */
    void off(Computer computer) {
        if(computer.isStarted) {
            computer.isStarted = false;
            System.out.println("Switch off.");
        } else {
            System.out.println("Computer already switched on.");
        }
    }
}
