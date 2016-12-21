package ua.training.computer;

import ua.training.computer.hard.Computer;
import ua.training.computer.hard.DVDDisk;

/**
 * <p> The Computer application class.
 * This class provides main executive method.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
public class ComputerApp {

    public static void main(String[] args) {
        try {
            Computer computer = new Computer();     // Initializing new computer
            DVDDisk disk = DVDDisk.DVD_DISK_WITH_DATA;  // Disk with data
            DVDDisk newDisk = new DVDDisk();    // Empty disk
            computer.switchOn();            // Switch on the computer at first
            computer.loadDisk(disk);        // Load disk with data
            computer.viewDVDData();         // Display information from the dvd disk
            computer.viewHDDData();         // Display information from hdd
            computer.copyFromDVDToHDD();    // Copy data from DVD to HDD
            computer.viewHDDData();         // Display information from HDD
            computer.ejectDisk();           // Eject disk from DVD-rom
            computer.loadDisk(newDisk);     // Load empty disk
            computer.viewDVDData();         // Display information from the dvd disk
            computer.copyFromHDDToDVD();    // Copy data from HDD to DVD
            computer.viewDVDData();         // Display information from the dvd disk
            computer.copyFromDVDToHDD();    // Copy data from DVD to HDD
            computer.viewHDDData();         // Display information from HDD
            computer.switchOff();           // Switch off the computer
            // Try to display information from HDD, but computer is switched off,
            // so exception will be thrown
            computer.viewHDDData();
        } catch (IllegalStateException ex) {
            System.out.println("Sorry. Computer is switched off.");
        }
    }

}
