package ua.training.watch;

/**
 * <p> The class represents Mechanical Watch Maker.
 * It implements WatchMaker interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.12.2016.
 */
public class MechanicalWatchMaker implements WatchMaker {
    /**
     * Factory method
     * @return - new Mechanical watch
     */
    @Override
    public Watch createWatch() {
        return new MechanicalWatch();
    }
}
