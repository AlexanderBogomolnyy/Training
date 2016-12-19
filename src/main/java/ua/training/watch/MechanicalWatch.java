package ua.training.watch;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p> The class represents Mechanical Watch.
 * It implements Watch interface
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.12.2016.
 */
public class MechanicalWatch implements Watch {

    /**
     * This method shows current time
     */
    @Override
    public void showTime() {
        Date date = new Date();
        SimpleDateFormat hours = new SimpleDateFormat("HH");
        SimpleDateFormat minutes = new SimpleDateFormat("mm");
        SimpleDateFormat seconds = new SimpleDateFormat("ss");
        System.out.println("Mechanical time " + "\u231b: " +
                "hours: " + hours.format(date) +
                "; minutes: " + minutes.format(date) +
                "; seconds: " + seconds.format(date) + ".");
    }

}
