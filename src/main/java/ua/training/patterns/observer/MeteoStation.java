package ua.training.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> The class represents Meteorological station and implements Observed interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 25.11.2016.
 */
class MeteoStation implements Observed {
    private int temperature; //1. Observed also has and changes its conditions and sends these conditions changes
    private int presser;     //to subscribers, and Mediator does not do it.

    List<Observer> observers = new ArrayList<>(); //2. Has list only of Observers and does not make differences between them

    public void setMeasurements(int temperature, int presser) { //3. Observed has method, which changes its conditions,
        this.temperature = temperature;                         //and it thoughtlessly sends information about changes
        this.presser = presser;                                 //to its observers (without any selection)
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
       observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers) {
            observer.handleEvent(temperature, presser);
        }
    }
}
