package ua.training.watch;

/**
 * <p> The class represents digital Watch Maker.
 * It implements WatchMaker interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.12.2016.
 */
public class DigitalWatchMaker implements WatchMaker {
    /**
     * Factory method
     * @return - new Digital watch
     */
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}
