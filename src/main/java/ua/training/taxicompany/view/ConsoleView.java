package ua.training.taxicompany.view;

import java.util.Collection;

/**
 * <p> The input form view class.
 * It represents the console view of input form.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 15.11.2016.
 */
public class ConsoleView {
    /**
     * A constant holding the application introduction.
     */
    public static final String INTRODUCTION = "---== TAXI Company ==---";

    /**
     * A constant holding the data loading exception information.
     */
    public static final String FILE_IO_EXCEPTION = "Data have not been load from file.";

    /**
     * A constant holding the information message about wrong data format in
     * data file current line.
     */
    public static final String PARSING_EXCEPTION = "Something wrong with data in this line.\nLine:";

    /**
     * A constant holding the massage about great data loading.
     */
    public static final String DATA_LOADING = " items from the file omitted!";

    /**
     * A constant holding the information massage about loading car list.
     */
    public static final String LOADING_CAR_LIST = "Taxi car list: ";

    /**
     * A constant holding the information massage about outputting cars
     * selected by speed range.
     */
    public static final String CAR_IN_RANGE = "Taxis in speed range: ";

    /**
     * A constant holding the information massage about cars total cost.
     */
    public static final String CARS_TOTAL_COST = "Total cars cost: ";

    /**
     * A constant holding the information massage about sorting by fuel rate.
     */
    public static final String SORTED_BY_FUEL_RATE = "Car list sorted by fuel rate: ";

    /**
     * This method outputs the text message to the console with line feed
     *
     * @param message - message to output
     */
    public void printlnMessage(String message){
        System.out.println(message);
    }

    /**
     * This method outputs the text message to the console without line feed
     *
     * @param message - message to output
     */
    public void printMessage(String message){
        System.out.print(message);
    }

    /**
     * This method successively outputs the elements from the collection into the console
     * applying to toString() method to each one
     *
     * @param collection - {@link Collection} of elements
     */
    public void printCollection(Collection collection) {
        collection.forEach(System.out::println);
    }

    /**
     * This method outputs the text messages to the console with line feed in tht end
     *
     * @param messages - message enumeration to output
     */
    public void printlnMessage(String... messages){
        for (String string: messages)
            System.out.print(string + " ");
        System.out.println("");
    }

}
