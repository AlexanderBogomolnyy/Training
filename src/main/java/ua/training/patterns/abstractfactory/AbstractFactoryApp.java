package ua.training.patterns.abstractfactory;

/**
 * <p> The Abstract Factory pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
public class AbstractFactoryApp {

    public static void main(String[] args) {

        DeviceFactory factory = getFactoryByCountryCode("EN");
        Mouse mouse = factory.getMouse();
        Keyboard keyboard = factory.getKeyboard();
        TouchPad touchPad = factory.getTouchPad();

        mouse.click();
        mouse.doubleClick();
        mouse.scroll(12);
        keyboard.print();
        keyboard.println();
        touchPad.track(10, 35);

    }

    // this method returns factory by country code (language)
    private static DeviceFactory getFactoryByCountryCode(String language) {
        switch (language) {
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EnDeviceFactory();
            default:
                throw new RuntimeException("Unsupported country code: " + language);
        }
    }
}
