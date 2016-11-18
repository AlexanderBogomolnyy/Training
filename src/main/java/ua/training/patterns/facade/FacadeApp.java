package ua.training.patterns.facade;

/**
 * <p> The Facade pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
public class FacadeApp {
    public static void main(String[] args) {

        // Create instances of different computer parts and call method on them
//        Power power = new Power();
//        power.on();
//        DVDRom dvd = new DVDRom();
//        dvd.load();
//        dvd.unload();
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvd);

        // Create only one instance of "Facade" class and call only one functional
        // method on it (we get the same logic of working as in previous lines)
        // All the difficulties of working with computer parts hidden from consumer
        Computer computer = new Computer();
        computer.copy();

    }
}
