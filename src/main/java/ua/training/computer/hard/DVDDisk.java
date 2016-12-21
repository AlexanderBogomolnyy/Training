package ua.training.computer.hard;

/**
 * <p> This class represents model of DVD disk.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
public class DVDDisk {

    /**
     * This constant contains some disk with data
     */
    public static final DVDDisk DVD_DISK_WITH_DATA = new DVDDisk("Disk with data.");

    /**
     * Data on the disk
     */
    private String data;

    public DVDDisk(){
    }

    /**
     * This constructor prevents creating disk with data without utilizing DVD-rom drive.
     * Disk with data can be produced directly only inside the class.
     *
     * @param data - some kind of data
     */
    private DVDDisk(String data) {
        this.data = data;
    }

    /**
     * THis method returns data from the disk
     *
     * @return - data
     */
    String getData() {
        return data;
    }

    /**
     * This method writes data to the disk
     *
     * @param data - some kind of data
     */
    void setData(String data) {
        this.data = data;
    }

}
