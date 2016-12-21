package ua.training.computer.hard;

/**
 * <p> The I/O accessible interface for devices.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
interface IOAccessible {

    /**
     * This method reads data from device
     *
     * @return read data
     */
    String read();

    /**
     * This method writes data to device
     *
     * @param data - some kind of data
     */
    void write(String data);
}
