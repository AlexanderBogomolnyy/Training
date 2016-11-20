package ua.training.patterns.factorymethod;

/**
 * <p> The Factory Method pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
public class FactoryMethodApp {
    public static void main(String[] args) {
//        Watch watch = new DigitalWatch();
//        Watch watch = new RomeWatch();
//        watch.showTime();

//        WatchMaker maker = new DigitalWatchMaker();
//        WatchMaker maker = new RomeWatchMaker();
//        WatchMaker maker = getMakerByName("Digital");
        WatchMaker maker = getMakerByName("Rome");
        Watch watch = maker.createWatch();
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
        if(maker.equals("Digital")) {
            return new DigitalWatchMaker();
        } else if (maker.equals("Rome"))
            return new RomeWatchMaker();
        throw new RuntimeException("Unsupported production line of watches: " + maker);
    }

}
