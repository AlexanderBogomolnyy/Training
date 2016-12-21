package ua.training.computer.hard;

/**
 * <p> This class represents computer.
 * This class contains methods which hide from user all details of working with
 * computer part and give only functional intuitive clear interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
public class Computer {

    /**
     * This field true if computer have been started.
     */
    boolean isStarted = false;

    /**
     * The power supply
     */
    private PowerSupply powerSupply = new PowerSupply();

    /**
     * The main processor
     */
    private Processor processor = new Processor();

    /**
     * The DVD rom drive
     */
    private DVDRom dvd = new DVDRom();

    /**
     * the HDD disk
     */
    private HDD hdd = new HDD();

    /**
     * The computer output device
     */
    private OutputDevice output = new OutputDevice();

    /**
     * Creating of computer and initializing power supply
     */
    public Computer() {
        this.powerSupply = new PowerSupply();
    }

    // This method checks if computer is started
    private void checkActivation() {
        if (!isStarted) {
            throw new IllegalStateException("Switch on the computer previously!");
        }
    }

    /**
     * This method loads disk into DVD-rom
     *
     * @param disk - some kind of disk
     */
    public void loadDisk(DVDDisk disk) {
        checkActivation();
        if (dvd.hasData()) {
            System.out.println("Eject previous disk...");
        } else {
            dvd.load(disk);
        }
    }

    /**
     * This method ejects disk from DVD-rom
     *
     * @return - disk from DVD-rom
     */
    public DVDDisk ejectDisk() {
        checkActivation();
        if (dvd.hasDisk()) {
            return dvd.unload();
        } else {
            System.out.println("DVD rom is empty.");
        }
        return null;
    }


    /**
     * This method shows data on DVD utilizing some output device
     */
    public void viewDVDData() {
        checkActivation();
        if(!dvd.hasDisk()) {
            System.out.println("Insert disk previously.");
        } else if (!dvd.hasData()) {
            System.out.println("DVD disk is empty.");
        } else {
            output.out("DVD: \"" + dvd.read() + "\"");
        }
    }

    /**
     * This method shows data on HDD utilizing some output device
     */
    public void viewHDDData() {
        checkActivation();
        if (!hdd.hasData()) {
            System.out.println("HDD is empty.");
        } else {
            output.out("HDD: \"" + hdd.read() + "\"");
        }
    }

    /**
     * This method represents main logic of copying data from DVD to HDD.
     */
    public void copyFromDVDToHDD() {
        checkActivation();
        if (dvd.hasData()) {
            System.out.println("Copying data from DVD to HDD.");
            processor.copyData(dvd, hdd);
        } else {
            System.out.println("Install disk with data.");
        }
    }

    /**
     * This method represents main logic of copying data from HDD to DVD.
     */
    public void copyFromHDDToDVD() {
        checkActivation();
        if (hdd.hasData() && dvd.hasDisk()) {
            System.out.println("Copying data from HDD to DVD.");
            processor.copyData(hdd, dvd);
            System.out.println("Data on dvd: " + dvd.read());
        } else {
            System.out.println("HDD is empty or no disk in DVD-Rom.");
        }
    }

    /**
     * This method switch on the computer and initialize main computer components
     */
    public void switchOn() {
        if (powerSupply == null)
            throw new IllegalStateException("Something wrong with power supply.");
        powerSupply.on(this);
        this.processor = new Processor();
        this.hdd = new HDD();
        this.dvd = new DVDRom();
        this.output = new OutputDevice();
    }

    /**
     * This method switch off the computer
     */
    public void switchOff() {
        powerSupply.off(this);
        this.processor = null;
        this.hdd = null;
        this.dvd = null;
        this.output = null;
    }
}
