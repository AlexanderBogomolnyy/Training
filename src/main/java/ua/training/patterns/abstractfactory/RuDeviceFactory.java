package ua.training.patterns.abstractfactory;

/**
 * <p> The class implements Device Factory for Russian location.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 21.11.2016.
 */
public class RuDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new RuTouchPad();
    }
}
