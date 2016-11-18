package ua.training.patterns.facade;

/**
 * <p> This class represents model of computer HDD.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
public class HDD {

    /**
     * This method copies data from DVDRom drive
     *
     * @param dvd - DVDRom model
     */
    void copyFromDVD(DVDRom dvd) {
        if (dvd.hasData()) {
            System.out.println("Copying data from DVD to HDD.");
        } else {
            System.out.println("Install disk with data.");
        }
    }
}
