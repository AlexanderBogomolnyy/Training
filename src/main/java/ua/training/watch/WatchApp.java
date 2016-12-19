package ua.training.watch;

/**
 * <p> The Watch application class with main executive method.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.12.2016.
 */
public class WatchApp {

    public static void main(String[] args) {
        WatchMaker maker = getMakerByName("Mechanical");
        Watch watch = maker.createWatch();
        watch.showTime();
        maker = getMakerByName("Digital");
        watch = maker.createWatch();
        watch.showTime();
    }

    /**
     * This method returns Watch Maker by string Key.
     * It throws Runtime Exception, if we try to get watch maker by unsupported string key.
     *
     * @param maker - string key
     * @return - new Watch Maker
     */
    public static WatchMaker getMakerByName(String maker) {
        if (maker.equalsIgnoreCase("Digital")) {
            return new DigitalWatchMaker();
        } else if (maker.equalsIgnoreCase("Mechanical"))
            return new MechanicalWatchMaker();
        throw new RuntimeException("Unsupported production line of watches: " + maker);
    }

}
