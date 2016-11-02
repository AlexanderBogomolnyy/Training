package ua.training.block02.game;

import java.util.ArrayList;

/**
 * <p> The game view class.
 * It represents the console view for game.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 30.10.2016.
 */
public class View {

    /**
     * A constant holding the greeting.
     */
    public static final String GREETING = "--= Welcome to the MORE-LESS GAME =--";

    /**
     * A constant holding the help additional information.
     */
    public static final String HELP = "If you want to stop the game immediately just type \"stop\"!";

    /**
     * A constant holding the proposal to type some value or command.
     */
    public static final String PROPOSAL = "Please, enter command or int value in range ";

    /**
     * A constant holding the wrong input warning.
     */
    public static final String WRONG_INPUT_VALUE = "Wrong input value. ";

    /**
     * A constant holding the try again message.
     */
    public static final String TRY_AGAIN= "Try again! ";

    /**
     * A constant holding the out of range warning.
     */
    public static final String OUT_OF_RANGE = "Value is out of range. ";

    /**
     * A constant holding the congratulation message.
     */
    public static final String CONGRATULATION = "Congratulations! You are win! ";

    /**
     * A constant holding the win number prefix message.
     */
    public static final String WIN_NUMBER_MESSAGE = "Win number is - ";

    /**
     * A constant holding the statistics headline message.
     */
    public static final String STATISTIC = "Game statistics: ";

    /**
     * A constant holding the game over message.
     */
    public static final String GAME_OVER = "Game over!";

    /**
     * This method outputs the text message to the console
     *
     * @param message - message to output
     */
    public void printMessage(String message){
        System.out.print(message);
    }

    /**
     * This method outputs the text message and the integer value into the console
     *
     * @param message - message to output
     * @param value - integer value to output
     */
    public void printMessageAndInt(String message, int value){
        System.out.println(message + value);
    }

    /**
     * This method outputs the text message and the integer range into the console
     *
     * @param message - message to output
     * @param start - start value of the range to output
     * @param end - end value of the range to output
     */
    public void printMessageAndRange(String message, int start, int end){
        System.out.print(message + "(" + start + " , " + end + "): ");
    }

    /**
     * This method successively outputs the elements from the list into the console
     * applying to toString() method to each one
     *
     * @param list - {@link ArrayList} of elements
    */
    public void printList(ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).toString() + " ");
        }
        System.out.println();
    }

}
