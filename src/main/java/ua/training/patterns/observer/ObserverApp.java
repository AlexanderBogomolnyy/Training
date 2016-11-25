package ua.training.patterns.observer;

/**
 * <p> The Observer pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 25.11.2016.
 */
public class ObserverApp {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();

        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());
        station.setMeasurements(25, 760);
        station.setMeasurements(-5, 745);
    }
}
