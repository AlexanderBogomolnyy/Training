package ua.training.block04.controller;

import ua.training.block04.model.Address;
import ua.training.block04.model.Group;
import ua.training.block04.model.Note;
import ua.training.block04.model.Notebook;
import ua.training.block04.view.View;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * <p> The controller class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 06.11.2016.
 */
public class Controller {

    /**
     * A constant holding the affirmative response value.
     */
    public static final String YES_RESPONSE = "Y";

    /**
     * A constant holding the input interrupting command.
     */
    public static final String STOP_COMMAND = "stop";

    /**
     * A constant holding the input process interrupt code.
     */
    public static final String INTERRUPT_CODE = "$CUSTOMER INTERRUPTION OF PROGRAM$ _stop_";

    /**
     * Notebook instance
     */
    private Notebook notebook;

    /**
     * Application view
     */
    private View view;

    public Controller(Notebook notebook, View view) {
        this.notebook = notebook;
        this.view = view;
    }

    /**
     * Form input executive method
     */
    public void execute() {
        view.printMessage(View.INTRODUCTION + "\n");
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            if (!(inputValueWithScanner(scanner, View.ADD_REQUEST)).equalsIgnoreCase(YES_RESPONSE)) {
                break;
            }
            view.printMessage(View.HELP + "\n");
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_NAME, FormValidationRegexes.NAME, View.NAME_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            String name = input;
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_PATRONYMIC, FormValidationRegexes.NAME, View.PATRONYMIC_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            String patronymic = input;
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_SURNAME, FormValidationRegexes.NAME, View.SURNAME_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            String surname = input;
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_NICKNAME, FormValidationRegexes.NICKNAME, View.NICKNAME_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            String nickname = input;
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_COMMENT, FormValidationRegexes.COMMENT, View.COMMENT_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            String comment = input;
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_GROUP, FormValidationRegexes.GROUP, View.GROUP_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            Group group = Group.valueOf(input.toUpperCase());
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_HOME_PHONE_NUMBER, FormValidationRegexes.HOME_PHONE_NUMBER, View.HOME_PHONE_NUMBER_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            String homeNumber = input;
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_MOBILE_PHONE_NUMBER, FormValidationRegexes.MOBILE_PHONE_NUMBER, View.MOBILE_PHONE_NUMBER_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            String mobileNumber1 = input;
            if (inputValueWithScanner(scanner, View.ONE_MORE_PHONE_NUMBER_REQUEST).equalsIgnoreCase(YES_RESPONSE)) {
                input = getValidValue(scanner, View.FORM_INPUT_REQUEST_MOBILE_PHONE_NUMBER, FormValidationRegexes.MOBILE_PHONE_NUMBER, View.MOBILE_PHONE_NUMBER_INPUT_ERROR);
            } else {
                input = "";
            }
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            String mobileNumber2 = input;
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_EMAIL, FormValidationRegexes.EMAIL, View.EMAIL_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            String email = input;
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_SKYPE, FormValidationRegexes.MESSENGER, View.SKYPE_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            String skype = input;
            view.printMessage(View.FORM_INPUT_REQUEST_ADDRESS + "\n");
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_ZIP, FormValidationRegexes.ZIP_CODE, View.ZIP_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            String zip = input;
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_CITY, FormValidationRegexes.CITY_NAME, View.CITY_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            String city = input;
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_STREET, FormValidationRegexes.STREET_NAME, View.STREET_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            String street = input;
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_BUILDING, FormValidationRegexes.BUILDING_NUMBER, View.BUILDING_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            String building = input;
            input = getValidValue(scanner, View.FORM_INPUT_REQUEST_APARTMENT, FormValidationRegexes.APARTMENT_NUMBER, View.APARTMENT_INPUT_ERROR);
            if (input.equals(INTERRUPT_CODE)) {
                break;
            }
            int apartment = Integer.parseInt(input);

            // creation of new note and providing it by data
            Note note = new Note();
            note.setName(name);
            note.setPatronymic(patronymic);
            note.setSurname(surname);
            note.setNickname(nickname);
            note.setComment(comment);
            note.setGroup(group);
            note.setHomeNumber(homeNumber);
            note.setMobileNumber1(mobileNumber1);
            note.setMobileNumber2(mobileNumber2);
            note.setEmail(email);
            note.setMessenger(skype);
            // creation of new address and providing it by data
            Address address = new Address();
            address.setZip(zip);
            address.setCity(city);
            address.setStreet(street);
            address.setBuilding(building);
            address.setApartment(apartment);
            // adding address to the note
            note.setAddress(address);
            note.setShortName();
            note.setStringAddress();
            // adding note to notebook
            notebook.addNote(note);
        }
        view.printMessage(notebook.toString());
    }

    /**
     * This method reads data from input stream and returns {@link String} value
     *
     * @param scanner - {@link Scanner} for input stream
     * @return {@link String} value of entered data
     */
    public String inputValueWithScanner(Scanner scanner, String proposal) {
        view.printMessage(proposal);
        return scanner.nextLine();
    }

    /**
     * This method gets value from the {@link Scanner}, validates it according to the pattern
     * and returns valid one.
     * This method can return {@link Controller#INTERRUPT_CODE} if receives {@link Controller#STOP_COMMAND}
     * on the {@link Scanner}.
     * If {@link Scanner} detects wrong input value, the method output error message to the view.
     *
     * @param scanner - input stream {@link Scanner}
     * @param proposal - input proposal
     * @param pattern - pattern for validation
     * @param errorMessage - validation error message
     * @return - valid input value or {@link Controller#INTERRUPT_CODE}
     */
    public String getValidValue(Scanner scanner, String proposal, Pattern pattern, String errorMessage) {
        Validator validator = new Validator(pattern, errorMessage);
        String input;
        while (true) {
            if ((input = inputValueWithScanner(scanner, proposal)).equalsIgnoreCase(STOP_COMMAND)) {
                return INTERRUPT_CODE;
            }
            if (validator.isValid(input)) {
                return input;
            }
            view.printMessage(View.WRONG_INPUT_VALUE + validator.getErrorMessage() + View.TRY_AGAIN + "\n");
        }
    }
}
