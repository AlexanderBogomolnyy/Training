package ua.training.patterns.abstractfactory;

/**
 * <p> The class implements Touch Pad device behavior for English location.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 21.11.2016.
 */
public class EnTouchPad  implements TouchPad {
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Moved " + s + " pixels");
    }
}
