package ua.training.patterns.abstractfactory;

/**
 * <p> The class implements Touch Pad device behavior for Russian location.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 21.11.2016.
 */
public class RuTouchPad  implements TouchPad {
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Передвинулись на " + s + " пикселей");
    }
}
