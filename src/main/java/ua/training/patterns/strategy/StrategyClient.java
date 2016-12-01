package ua.training.patterns.strategy;

/**
 * <p> The Strategy Client class.
 * This class receives Strategy interface (Sorting) as a parameter of constructor.
 * This is context class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 01.12.2016.
 */
class StrategyClient {
    private Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    /**
     * Execute method for strategy.
     *
     * @param array array for sorting
     */
    public void executeStrategy(int[] array) {
        strategy.sort(array);
    }

}
