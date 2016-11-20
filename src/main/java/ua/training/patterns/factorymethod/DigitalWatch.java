package ua.training.patterns.factorymethod;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p> The class represents digital Watch.
 * It implements Watch interface
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
public class DigitalWatch implements Watch {

    /**
     * This method shows current digital time
     */
    @Override
    public void showTime() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        System.out.println("\u231b " +  format.format(new Date()));
    }
}
