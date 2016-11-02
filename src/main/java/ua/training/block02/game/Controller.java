package ua.training.block02.game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p> The game controller class.
 * It represents the game play.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 30.10.2016.
 */
public class Controller {

    /**
     * A constant holding the game stop command.
     */
    public static final String STOP_COMMAND = "stop";

    /**
     * Game model
     */
    private Model model;
    /**
     * Game view
     */
    private View view;

    /**
     * Game statistics
     */
    private ArrayList<Attempt> statistics;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
        this.statistics = new ArrayList<>();
    }

    /**
     * This is the main game play method.
     */
    public void start() {
        view.printMessage(View.GREETING + "\n" + View.HELP + "\n");
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            // control if "stop" command is entered
            if ((input = inputValueWithScanner(scanner)).equalsIgnoreCase(STOP_COMMAND)) {
                statistics.add(new Attempt(input, View.GAME_OVER));
                break;
            }
            try {
                // try to parse entered string value to int
                int sample = Integer.parseInt(input);
                // show message if entered value is out of current game range
                if (!model.inRange(sample)) {
                    view.printMessage(View.OUT_OF_RANGE + View.TRY_AGAIN);
                    statistics.add(new Attempt(input, View.OUT_OF_RANGE));
                    continue;
                }
                // show message if you are win or write statistics
                if (model.compareWithGoal(sample) == 0) {
                    view.printMessage(View.CONGRATULATION);
                    view.printMessageAndInt(View.WIN_NUMBER_MESSAGE, sample);
                    statistics.add(new Attempt(input, View.CONGRATULATION));
                    break;
                } else {
                    statistics.add(new Attempt(input, String.format(View.RANGE, model.getBottom(), model.getTop())));
                }
            } catch (NumberFormatException ex) {
                // catch exception if entered string value have not been parsed to integer value
                // show warning message and write statistics
                statistics.add(new Attempt(input, View.WRONG_INPUT_VALUE));
                view.printMessage(View.WRONG_INPUT_VALUE + View.TRY_AGAIN);
            }
        }
        // show statistics
        view.printMessage(View.GAME_OVER + "\n" + View.STATISTIC + "\n");
        view.printList(statistics);
    }

    /**
     * This method reads data from input stream
     *
     * @param scanner - {@link Scanner} for input stream
     * @return {@link String} value of entered data
     */
    public String inputValueWithScanner(Scanner scanner) {
        view.printMessageAndRange(View.PROPOSAL, model.getBottom(), model.getTop());
        return scanner.nextLine();
    }

    /**
     * <p> The controller inner class.
     * It describes the key-value representation for an input attempt.
     * Class contains input value and some message describing this input.
     *
     * @author Alexander Bogomolnyy
     * @version 1.0 30.10.2016.
     */
    private class Attempt {

        private String value;

        private String result;

        Attempt(String value, String result) {
            this.value = value;
            this.result = result;
        }

        String getValue() {
            return value;
        }

        void setValue(String value) {
            this.value = value;
        }

        String getResult() {
            return result;
        }

        void setResult(String result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return value + " : " + result;
        }
    }
}
