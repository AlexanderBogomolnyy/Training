package ua.training.taxicompany.controller;

import ua.training.taxicompany.model.Car;
import ua.training.taxicompany.model.CarFuelRateComparator;
import ua.training.taxicompany.model.Taxi;
import ua.training.taxicompany.model.TaxiCompany;
import ua.training.taxicompany.view.ConsoleView;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p> The controller class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 14.11.2016.
 */
public class Controller {

    /**
     * A constant holding the path to the directory with resources file
     */
    public static final String DATA_DIR_PATH = System.getProperty("user.dir") + "/src/main/resources/";

    /**
     * The model
     */
    private TaxiCompany company;

    /**
     * The view
     */
    private ConsoleView view;

    public Controller(TaxiCompany company, ConsoleView view) {
        this.company = company;
        this.view = view;
    }

    /**
     * Main executing method of controller
     */
    public void execute() {
        view.printlnMessage(ConsoleView.INTRODUCTION);

        Collection<Taxi> taxis = new ArrayList<>();
        try {
            int size = loadFromFile(DATA_DIR_PATH + "data.dat", taxis);
            view.printMessage(String.valueOf(size));
            view.printlnMessage(ConsoleView.DATA_LOADING);
            view.printlnMessage("");
        } catch (IOException e) {
            view.printlnMessage(ConsoleView.FILE_IO_EXCEPTION);
        }

        view.printlnMessage(ConsoleView.LOADING_CAR_LIST);
        view.printCollection(taxis);
        view.printlnMessage("");

        company.setTaxis(taxis);

        view.printlnMessage(ConsoleView.CAR_IN_RANGE);
        Collection<Taxi> taxisInRange = company.getInSpeedRange(170, 190);
        view.printCollection(taxisInRange);
        view.printlnMessage("");

        int carsTotalCost = company.totalCarsCost();
        view.printlnMessage(ConsoleView.CARS_TOTAL_COST, String.valueOf(carsTotalCost));
        view.printlnMessage("");

        List<Taxi> sortedTaxis = company.getSortedCarList(new CarFuelRateComparator<>());
        view.printlnMessage(ConsoleView.SORTED_BY_FUEL_RATE);
        view.printCollection(sortedTaxis);

    }

    /**
     * This method loads data from file to the Taxi collection
     *
     * @param file - data source file
     * @param taxis - collection for filling
     * @return - number of omitted lines during reading file
     * @throws IOException - if file can not be read
     */
    public int loadFromFile(String file, Collection<Taxi> taxis) throws IOException {
        int counter = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            String line = reader.readLine();
            String[] resultSet = line.split(":");
            if (resultSet.length == 7) {
                try {
                    String model = resultSet[0];
                    Car.Type type = Car.Type.valueOf(resultSet[1].toUpperCase());
                    String numberPlate = resultSet[2];
                    int primeCost = Integer.valueOf(resultSet[3]);
                    double fuelRate = Double.valueOf(resultSet[4]);
                    int  fullSpeed = Integer.valueOf(resultSet[5]);
                    String regularNumber = resultSet[6];
                    Taxi taxi = new Taxi(model, type, numberPlate, primeCost, fuelRate, fullSpeed, regularNumber);
                    taxis.add(taxi);
                } catch (Exception ex) {
                    counter++;
                    view.printlnMessage(ConsoleView.PARSING_EXCEPTION, line);
                }
            }
        }
        return counter;
    }
}
