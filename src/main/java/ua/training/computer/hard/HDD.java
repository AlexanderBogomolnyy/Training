package ua.training.computer.hard;

/**
 * <p> This class represents model of computer HDD.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
class HDD implements IOAccessible {

    /**
     * Containing data
     */
    private String dataStore = "";

    /**
     * This method returns information about data presence on HDD
     *
     * @return true, if data is present on HDD
     */
    boolean hasData() {
        return !dataStore.isEmpty();
    }

    /**
     * This method reads data from hdd
     *
     * @return read data
     */
    @Override
    public String read() {
        return dataStore;
    }

    /**
     * This method writes data to hdd
     *
     * @param data - some kind of data
     */
    @Override
    public void write(String data) {
        dataStore += data;
    }
}
