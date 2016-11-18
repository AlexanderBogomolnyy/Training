package ua.training.patterns.facade;

/**
 * <p> This class represents model of computer DVDRom drive.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
class DVDRom {

    /**
     * Flag for containing data
     */
    private boolean data = false;

    /**
     * Checks if data presents.
     *
     * @return - true if data presents
     */
    public boolean hasData() {
        return data;
    }

    /**
     * Sets data field into true.
     * Data have loaded.
     */
    void load() {
        data = true;
    }

    /**
     * Sets data field into false.
     * Data have unloaded.
     */
    void unload() {
        data = false;
    }

}
