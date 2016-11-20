package ua.training.patterns.factorymethod;

import ua.training.patterns.factorymethod.util.RomeVSArabic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p> The class represents Rome Watch.
 * It implements Watch interface
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.11.2016.
 */
public class RomeWatch implements Watch {

    /**
     * This method shows current time (Rome numbers)
     */
    @Override
    public void showTime() {
        System.out.println("\u231b " + romeFormat(new Date()));
    }

    //This method parse Date to Rome number format
    private String romeFormat(Date date) {
        int hours = Integer.valueOf(new SimpleDateFormat("HH").format(date));
        int minutes = Integer.valueOf(new SimpleDateFormat("mm").format(date));
        int seconds = Integer.valueOf(new SimpleDateFormat("ss").format(date));
        return RomeVSArabic.convert(hours) + ":" +
                RomeVSArabic.convert(minutes) + ":" +
                RomeVSArabic.convert(seconds);
    }
}
