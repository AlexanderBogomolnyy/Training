package ua.training.block02.game;

import java.util.ArrayList;

/**
 * <p> The main model class.
 * It describes the game instance and its behaviour.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 30.10.2016.
 */
public class Model {

    /**
     * Secret number offered by game.
     */
    private int secretValue;

    /**
     * Minimum game barrier
     */
    private int minBarrier;

    /**
     * Maximum game barrier
     */
    private int maxBarrier;

    private ArrayList<Integer> statistics;

    /**
     * The constructor without parameters.
     */
    public Model() {
        statistics = new ArrayList<>();
    }

    /**
     * The method checks matching trial value to secret one.
     * If values is not te same, the trial value sets as a minimum barrier, if it is less
     * than secret value and sets as maximum in opposite one.
     * The method adds value to the current game statistics.
     *
     * @param value - check value
     * @return true if value is te same as secret one
     *         false in other case
     */
    public boolean checkValue(int value) {
        statistics.add(value);
        if (value == secretValue) return true;
        if (value > secretValue) {
            maxBarrier = value;
        } else {
            minBarrier = value;
        }
        return false;
    }

    /**
     * This method tests trial value for accessory to the current game value range.
     *
     * @param value - test value
     * @return true - if value is in current game range
     */
    public boolean inRange(int value) {
        return value > minBarrier && value < maxBarrier;
    }

    /**
     * The method sets minimum and maximum barriers.
     *
     * @param minBarrier - value of minimum barrier
     * @param maxBarrier - value of maximum barrier
     */
    public void setPrimaryBarrier(int minBarrier, int maxBarrier) {
        if (minBarrier > maxBarrier)
            throw new IllegalArgumentException("Minimum barrier cannot be bigger than maximum one.");
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
    }

    /**
     * The method generates and sets game secret value.
     */
    public void setSecretValue() {
        this.secretValue = (int)Math.ceil(Math.random()*(maxBarrier - minBarrier - 1) + minBarrier);
    }

    /**
     * The method initialize new empty statistics of the game.
     * After calling previous statistics will be lost.
     */
    public void newStatistics() {
        this.statistics = new ArrayList<>();
    }

    public ArrayList<Integer> getStatistics() {
        return statistics;
    }

    public int getSecretValue() {
        return secretValue;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

}
