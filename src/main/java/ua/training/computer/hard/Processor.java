package ua.training.computer.hard;

/**
 * <p> This class represents model of computer main processor.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
class Processor {

    /**
     * This method copies data from source device to destiny one.
     *
     * @param source - some data source implements IOAccessible interface
     * @param destiny - some data receiver implements IOAccessible interface
     */
    void copyData(IOAccessible source, IOAccessible destiny) {
        System.out.println("Coping data utilizing main processor...");
        destiny.write(source.read());
    }
}
