package ua.training.taxicompany.model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p> The Taxi Company model class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 14.11.2016.
 */
public class TaxiCompany {

    /**
     * Company name
     */
    private String name;

    /**
     * Collection of car in company
     */
    private Collection<Taxi> taxis;

    public TaxiCompany(String name) {
        this.name = name;
        taxis = new ArrayList<>();
    }

    public TaxiCompany(String name, Collection<Taxi> taxis) {
        this.name = name;
        this.taxis = taxis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Taxi> getTaxis() {
        return taxis;
    }

    public void setTaxis(Collection<Taxi> taxis) {
        this.taxis = taxis;
    }

    public void addTaxi(Taxi taxi) {
        taxis.add(taxi);
    }

    /**
     * This method calculates total cost of all cars in company
     *
     * @return - total cost of all cars in company
     */
    public int totalCarsCost() {
        int sum = 0;
        for (Taxi taxi: taxis) {
            sum += taxi.getPrimeCost();
        }
        return sum;
    }

    /**
     * This method extracts collection of taxis
     *
     * @param minSpeed - minimum speed
     * @param maxSpeed - maximum speed
     * @return - collection of taxis in range
     * @throws IllegalArgumentException - throws if one of the parameters is less then zero,
     *                                      or maxSpeed less then minSpeed
     */
    public Collection<Taxi> getInSpeedRange(int minSpeed, int maxSpeed) {
        if (maxSpeed < 0 || minSpeed < 0 || maxSpeed < minSpeed)
            throw new IllegalArgumentException();
        Collection<Taxi> taxiList = new ArrayList<>();
        for(Taxi taxi: taxis) {
            if (taxi.getFullSpeed() >= minSpeed && taxi.getFullSpeed() <= maxSpeed) {
                taxiList.add(taxi);
            }
        }
        return taxiList;
    }

    /**
     * This method returns list of cars sorted by comparator
     *
     * @param comparator - comparator for cars
     * @return - sorted list of cars
     */
    public List<Taxi> getSortedCarList(Comparator<Taxi> comparator) {
        List<Taxi> result = taxis.stream().collect(Collectors.toList());
        Collections.sort(result, comparator);
        return result;
    }

}
