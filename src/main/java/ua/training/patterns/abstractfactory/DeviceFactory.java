package ua.training.patterns.abstractfactory;

/**
 * <p> The interface describes Device Factory.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 21.11.2016.
 */
public interface DeviceFactory {
    Mouse getMouse();
    Keyboard getKeyboard();
    TouchPad getTouchPad();
}
