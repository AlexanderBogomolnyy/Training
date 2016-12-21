package ua.training.computer.hard;

/**
 * <p> This class represents model of computer DVDRom drive.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
class DVDRom implements IOAccessible {

    /**
     * The DVD disk
     */
    private DVDDisk disk;

    /**
     * This field is true if disk has been loaded
     */
    private boolean isLoaded = false;

    /**
     * Checking of disk loading.
     *
     * @return - true if data is present on disk
     */
    boolean hasData() {
        return hasDisk() && disk.getData() != null && !disk.getData().isEmpty();
    }

    /**
     * Checking of disk presenting
     *
     * @return - true if disk is present in drive and data is loaded.
     */
    boolean hasDisk() {
        return disk != null && isLoaded;
    }

    /**
     * This method loads disk
     */
    void load(DVDDisk disk) {
        this.disk = disk;
        isLoaded = true;
    }

    /**
     * This method unloads disk
     *
     * @return - old disk
     */
    DVDDisk unload() {
        DVDDisk old = disk;
        disk = null;
        isLoaded = false;
        return old;
    }

    /**
     * This method reads data from disk
     *
     * @return read data
     */
    @Override
    public String read() {
        return disk.getData();
    }

    /**
     * This method writes data to disk
     *
     * @param data - some kind of data
     */
    @Override
    public void write(String data) {
        disk.setData(data);
    }
}
