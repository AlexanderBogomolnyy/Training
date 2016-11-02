package ua.training.block02.game;

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
     * A constant holding the enter process interrupt integer value.
     */
    public static final int INTERRUPT_CODE = Integer.MIN_VALUE;

    /**
     * Game model
     */
    private Model model;
    /**
     * Game view
     */
    private View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    /**
     * This is the main game play method.
     */
    public void start() {
        view.printMessage(View.GREETING + "\n" + View.HELP + "\n");

        Scanner scanner = new Scanner(System.in);

//        model.setPrimaryBarrier(GameSettings.PRIMARY_MIN_BARRIER, GameSettings.PRIMARY_MAX_BARRIER);
        initPrimaryBarriers(scanner);
        model.setSecretValue();





        int goal;
        while ((goal = inputIntValueWithScanner(scanner))!=INTERRUPT_CODE) {
            if (model.checkValue(goal)) {
                view.printMessage(View.CONGRATULATION);
                view.printMessageAndInt(View.WIN_NUMBER_MESSAGE, goal);
                break;
            }
        }

        // show statistics
        view.printMessage(View.GAME_OVER + "\n" + View.STATISTIC + "\n");
        view.printList(model.getStatistics());
    }

    /**
     * This method reads data from input stream and returns {@link String} value
     *
     * @param scanner - {@link Scanner} for input stream
     * @return {@link String} value of entered data
     */
    public String inputValueWithScanner(Scanner scanner) {
        view.printMessageAndRange(View.PROPOSAL, model.getMinBarrier(), model.getMaxBarrier());
        return scanner.nextLine();
    }

    /**
     * This method reads data from input stream and returns {@link int} value
     *
     * @param scanner {@link Scanner} for input stream
     * @return {@link int} value of entered data
     *         or
     *         {@link Controller#INTERRUPT_CODE}, if entered {@link Controller#STOP_COMMAND}
     *
     */
    public int inputIntValueWithScanner(Scanner scanner) {
        int result;
        String input;
        while (true) {
            if ((input = inputValueWithScanner(scanner)).equalsIgnoreCase(STOP_COMMAND)) {
                return INTERRUPT_CODE;
            }
            try {
                // try to parse entered string value to int
                result = Integer.parseInt(input);
                // show message if entered value is out of current game range
                if (!model.inRange(result)) {
                    view.printMessage(View.OUT_OF_RANGE + View.TRY_AGAIN);
                    continue;
                }
                return result;
            } catch (NumberFormatException ex) {
                // catch exception if entered string value have not been parsed to integer value
                // show warning message and write statistics
                view.printMessage(View.WRONG_INPUT_VALUE + View.TRY_AGAIN);
            }
        }
    }

    /**
     * This method reads data from input stream and sets game primary barriers
     *
     * @param scanner {@link Scanner} for input stream
     */
    public void initPrimaryBarriers(Scanner scanner) {
        int minBarrier, maxBarrier;
        while (true) {
            view.printMessage(View.PROPOSAL_RANGE);
            try {
                if(scanner.hasNextInt()) minBarrier = scanner.nextInt();
                else {
                    scanner.next();
                    continue;
                }
                if (scanner.hasNextInt()) maxBarrier = scanner.nextInt();
                else {
                    scanner.next();
                    continue;
                }
                scanner.nextLine();
                model.setPrimaryBarrier(minBarrier, maxBarrier);
                break;
            } catch (IllegalArgumentException ex) {
                view.printMessage(View.WRONG_INPUT_VALUE + View.TRY_AGAIN);
            }
        }
    }

}
