package ua.training.patterns.facade;

/**
 * <p> This class represents computer.
 * This is "Facade" class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
public class Computer {

    /**
     * Power supply
     */
    Power power = new Power();

    /**
     * DVD rom drive
     */
    DVDRom dvd = new DVDRom();

    /**
     * Hdd
     */
    HDD hdd  = new HDD();


    /**
     * This method represents main logic of working with computer
     * specifically copying data from DVD.
     * We can place any logic of working with computer parts in similar method.
     * This method hides from user all details of working with computer part
     * and gives only functional intuitive clear interface.
     *
     */
    void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}
