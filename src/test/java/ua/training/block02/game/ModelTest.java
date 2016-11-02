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
        model.setPrimaryBarrier(GameSettings.PRIMARY_MIN_BARRIER, GameSettings.PRIMARY_MAX_BARRIER);
    }

    /**
     * Checking of {@link Model#checkValue(int)} method correct performing.
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testCheckValue() throws Exception {
        // test value checking
        model.setSecretValue();
        int secretValue = model.getSecretValue();
        for (int i = model.getMinBarrier() + 1; i < model.getMaxBarrier(); i++) {
            if (i == secretValue) assertTrue(model.checkValue(i));
            else assertFalse(model.checkValue(i));
        }
        // test barrier changes
        for (int i = 0; i < 1000; i++) {
            model.setPrimaryBarrier(GameSettings.PRIMARY_MIN_BARRIER, GameSettings.PRIMARY_MAX_BARRIER);
            model.setSecretValue();
            secretValue = model.getSecretValue();
            int leftShift = (int) Math.ceil((secretValue - GameSettings.PRIMARY_MIN_BARRIER) / 2) + GameSettings.PRIMARY_MIN_BARRIER;
            int rightShift = (int) Math.floor((GameSettings.PRIMARY_MAX_BARRIER - secretValue) / 2) + secretValue;
            if (leftShift != secretValue && rightShift != secretValue) {
                model.checkValue(leftShift);
                model.checkValue(rightShift);
                assertEquals(leftShift, model.getMinBarrier());
                assertEquals(rightShift, model.getMaxBarrier());
            }
            // check if statistics not empty
            assertFalse(model.getStatistics().isEmpty());
        }
        model.setPrimaryBarrier(GameSettings.PRIMARY_MIN_BARRIER, GameSettings.PRIMARY_MAX_BARRIER);
        model.setSecretValue();
        model.checkValue(model.getSecretValue());
        assertEquals(GameSettings.PRIMARY_MIN_BARRIER, model.getMinBarrier());
        assertEquals(GameSettings.PRIMARY_MAX_BARRIER, model.getMaxBarrier());
        assertFalse(model.getStatistics().isEmpty());
    }

    /**
     * Checking inclusion parameter value into the current game range.
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testInRange() throws Exception {
        for (int i = GameSettings.PRIMARY_MIN_BARRIER + 1; i < GameSettings.PRIMARY_MAX_BARRIER; i++) {
            assertTrue(model.inRange(i));
        }
        for (int i = Integer.MIN_VALUE; i <= GameSettings.PRIMARY_MIN_BARRIER; i++) {
            assertFalse(model.inRange(i));
        }
        for (int i = GameSettings.PRIMARY_MAX_BARRIER; i < Integer.MAX_VALUE; i++) {
            assertFalse(model.inRange(i));
        }
        assertFalse(model.inRange(Integer.MAX_VALUE));
    }

    /**
     * Testing of wrong argument position in {@link Model#setPrimaryBarrier(int, int)}
     * Incorrect sequence of parameters.
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testIllegalArgumentInSetPrimaryBarrier() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Minimum barrier cannot be bigger than maximum one.");
        model.setPrimaryBarrier(100, -1);
    }

    /**
     * Testing of wrong argument position in {@link Model#setPrimaryBarrier(int, int)}
     * Try to set empty range.
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testIllegalArgumentInSetPrimaryBarrierEmptyRange() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Empty range.");
        model.setPrimaryBarrier(5,6);
    }


    /**
     * Test setting min and max barriers in {@link Model}
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testSetPrimaryBarrier() throws Exception {
        assertEquals(GameSettings.PRIMARY_MIN_BARRIER, model.getMinBarrier());
        assertEquals(GameSettings.PRIMARY_MAX_BARRIER, model.getMaxBarrier());
        model.setPrimaryBarrier(-1, 1);
        assertEquals(-1, model.getMinBarrier());
        assertEquals(1, model.getMaxBarrier());
    }

    /**
     * Checking inclusion of secret values into the game range.
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testSetSecretValue() throws Exception {
        int secretValue;
        for(int i = 0; i < 10000; i++) {
            model.setSecretValue();
            secretValue = model.getSecretValue();
            assertTrue(secretValue > model.getMinBarrier() && secretValue < model.getMaxBarrier());
        }
    }

    /**
     * Test statistics reset
     *
     * @throws Exception - exception in test
     */
    @Test
    public void testNewStatistics() throws Exception {
        model.setSecretValue();
        for (int i = GameSettings.PRIMARY_MIN_BARRIER; i < GameSettings.PRIMARY_MAX_BARRIER; i+=10) {
            model.checkValue(i);
        }
        assertFalse(model.getStatistics().isEmpty());
        model.newStatistics();
        assertTrue(model.getStatistics().isEmpty());
    }

}