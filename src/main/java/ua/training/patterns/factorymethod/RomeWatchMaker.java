package ua.training.patterns.factorymethod;

/**
 * <p> The class represents Rome Watch Maker.
 * It implements WatchMaker interface.
 * This is class contains Factory method createWatch().
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
public class RomeWatchMaker implements WatchMaker {
    /**
     * Factory method
     * @return - new Rome watch
     */
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}
