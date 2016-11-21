package ua.training.patterns.abstractfactory;

/**
 * <p> The class implements Device Factory for English location.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 21.11.2016.
 */
public class EnDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new EnTouchPad();
    }
}
