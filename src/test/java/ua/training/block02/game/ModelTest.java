package ua.training.block02.game;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * <p> The model test class.
 * It contains tests for game constructors and public methods.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 30.10.2016.
 */
public class ModelTest {

    private Model model;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Initialising of default game for test
     */
    @Before
    public void init() {
        model = new Model();
    }

    /**
     * Testing of wrong argument position in Model constructor
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testIllegalRangeInConstructor() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Lower value of the range cannot be bigger than upper one.");
        model = new Model(100, -1);
    }

    /**
     * Testing of accessory of random goal value to the range over multiple
     * default constructor invocation
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testRandomDefaultGame() throws Exception{
        int firstGame = model.getGoal();
        int secondGame = new Model().getGoal();
        int thirdGame = new Model().getGoal();
        assertNotEquals(firstGame, secondGame);
        assertNotEquals(secondGame, thirdGame);
        assertNotEquals(firstGame, thirdGame);
    }

    /**
     * Testing of accessory of random goal value to the range over multiple
     * constructor invocation
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testRandomCustomGame() throws Exception{
        int firstGame = new Model(5, 50).getGoal();
        int secondGame = new Model(-5, 70).getGoal();
        int thirdGame = new Model(-50, 150).getGoal();
        assertNotEquals(firstGame, secondGame);
        assertNotEquals(secondGame, thirdGame);
        assertNotEquals(firstGame, thirdGame);
    }

    /**
     * Testing of accessory of goal value to the initial range
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testConstructorGoalInRange() throws Exception {
        int defaultOne = model.getGoal();
        assertTrue(defaultOne >= Model.MIN_RAND && defaultOne <= Model.MAX_RAND);
        int firstGame = new Model(5, 50).getGoal();
        assertTrue(firstGame >= 5 && firstGame <= 50);
        int secondGame = new Model(-5, 70).getGoal();
        assertTrue(secondGame >= -5 && secondGame <= 70);
        int thirdGame = new Model(-50, 150).getGoal();
        assertTrue(thirdGame >= -50 && thirdGame <= 150);
    }

    /**
     * Testing of method, which compare input value with the current game
     * range
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testCompareWithGoal() throws Exception {
        int goal = model.getGoal();
        assertEquals(0, model.compareWithGoal(goal));
        assertEquals(-1, model.compareWithGoal(goal - 5));
        assertEquals(1, model.compareWithGoal(goal + 5));
    }

    /**
     * Testing of method, which check an accessory of input value to the current
     * game range
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testInRange() throws Exception {
        assertFalse(model.inRange(-10));
        assertTrue(model.inRange(50));
        assertFalse(model.inRange(134));
    }
}