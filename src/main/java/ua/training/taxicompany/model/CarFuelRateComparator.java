package ua.training.taxicompany.model;

import java.util.Comparator;

/**
 * <p> The car fuel rate comparator.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 14.11.2016.
 */
public class CarFuelRateComparator<E extends Car> implements Comparator<E> {

    @Override
    public int compare(Car car1, Car car2) {
        return Double.compare(car1.getFuelRate(), car2.getFuelRate());
    }

    @Override
    public Comparator<E> reversed() {
        return (car1, car2) -> (0 - Double.compare(car1.getFuelRate(), car2.getFuelRate()));
    }

}
