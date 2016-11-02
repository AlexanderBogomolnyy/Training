package ua.training.block02.game;

/**
 * <p> The main model class.
 * It is describing the game instance and its behaviour.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 30.10.2016.
 */
public class Model {

    /**
     * A constant holding the minimum value of default range.
     */
    public static final int MIN_RAND = 0;

    /**
     * A constant holding the maximum value of default range.
     */
    public static final int MAX_RAND = 100;

    /**
     * Number offered by game.
     */
    private int goal;

    /**
     * Lower value of the range
     */
    private int bottom;

    /**
     * Upper limit of the range
     */
    private int top;

    /**
     * The constructor for default game.
     */
    public Model() {
        goal = randomValue(MIN_RAND, MAX_RAND);
        bottom = MIN_RAND;
        top = MAX_RAND;
    }

    /**
     *
     * The constructor for game started in custom range.
     *
     * @param bottom - lower value of the custom range
     * @param top - upper limit of the custom range
     */
    public Model(int bottom, int top) {
        goal = randomValue(bottom, top);
        this.bottom = bottom;
        this.top = top;
    }

    /**
     * This method generates random int value in given range.
     *
     * @param bottom - lower value of the range
     * @param top - upper limit of the range
     * @return random value in range
     */
    private int randomValue(int bottom, int top) {
        if (bottom > top)
            throw new IllegalArgumentException("Lower value of the range cannot be bigger than upper one.");
        return (int)(bottom + Math.random()*(top - bottom));
    }


    /**
     * This method compares trial value with current game range.
     *
     * @param attempt - test value
     * @return 0 - if attempt value equals to goal value
     *         -1 - if attempt value lower than goal value
     *         1 - if attempt value upper than goal value
     */
    public int compareWithGoal(int attempt) {
        if (goal == attempt) return 0;
        if (attempt < goal) {
            bottom = attempt;
            return -1;
        } else {
            top = attempt;
            return 1;
        }
    }

    /**
     * This method tests trial value for accessory to the current game value range.
     *
     * @param value - test value
     * @return true - if value is in current game range
     */
    public boolean inRange(int value) {
        return value >= bottom && value <= top;
    }

    public int getGoal() {
        return goal;
    }

    public int getBottom() {
        return bottom;
    }

    public int getTop() {
        return top;
    }
}
