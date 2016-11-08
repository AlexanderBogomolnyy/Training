package ua.training.block04.view;

import ua.training.block04.model.Group;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p> The input form view class.
 * It represents the console view of input form.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 06.11.2016.
 */
public class View {

    // Enter requests and error responses
    public static final String FORM_INPUT_REQUEST_NAME = "Enter the name: ";
    public static final String NAME_INPUT_ERROR = "Please, use only latin symbols. First letter must be capitalized. ";

    public static final String FORM_INPUT_REQUEST_PATRONYMIC = "Enter the patronymic: ";
    public static final String PATRONYMIC_INPUT_ERROR = NAME_INPUT_ERROR;

    public static final String FORM_INPUT_REQUEST_SURNAME = "Enter the surname: ";
    public static final String SURNAME_INPUT_ERROR = NAME_INPUT_ERROR;

    public static final String FORM_INPUT_REQUEST_NICKNAME = "Enter the nickname: ";
    public static final String NICKNAME_INPUT_ERROR = "Please, use only latin symbols. ";

    public static final String FORM_INPUT_REQUEST_COMMENT = "Enter the comment: ";
    public static final String COMMENT_INPUT_ERROR = "Please, use only latin symbols, numbers and punctuation marks. ";

    public static final String FORM_INPUT_REQUEST_GROUP = "Enter the group name " + Arrays.toString(Group.values())+ ": ";
    public static final String GROUP_INPUT_ERROR = "Please, use only provided name of group. ";

    public static final String FORM_INPUT_REQUEST_HOME_PHONE_NUMBER = "Enter the home phone number [XXX-XXX-XXXX]: ";
    public static final String HOME_PHONE_NUMBER_INPUT_ERROR = "Please, don't use characters and wrong symbols. ";

    public static final String FORM_INPUT_REQUEST_MOBILE_PHONE_NUMBER = "Enter the mobile phone number [+XX (XXX) XXX-XXXX]: ";
    public static final String MOBILE_PHONE_NUMBER_INPUT_ERROR = "Please, don't use characters and wrong symbols. ";

    public static final String FORM_INPUT_REQUEST_EMAIL = "Enter the e-mail: ";
    public static final String EMAIL_INPUT_ERROR = "Please, use correct e-mail format. ";

    public static final String FORM_INPUT_REQUEST_SKYPE = "Enter the Skype nickname: ";
    public static final String SKYPE_INPUT_ERROR = "Please, use correct Skype nickname format. ";

    public static final String FORM_INPUT_REQUEST_ADDRESS = "Enter the address: ";

    public static final String FORM_INPUT_REQUEST_ZIP = "\tEnter the zip code [XXXXX, XXXXX-XXXX]: ";
    public static final String ZIP_INPUT_ERROR = "\tPlease, use only numbers. ";

    public static final String FORM_INPUT_REQUEST_CITY = "\tEnter the city name: ";
    public static final String CITY_INPUT_ERROR = "\tPlease, use only characters. ";

    public static final String FORM_INPUT_REQUEST_STREET = "\tEnter the street: ";
    public static final String STREET_INPUT_ERROR = "\tPlease, use correct street name. ";

    public static final String FORM_INPUT_REQUEST_BUILDING = "\tEnter the building number: ";
    public static final String BUILDING_INPUT_ERROR = "\tPlease, use correct building number. ";

    public static final String FORM_INPUT_REQUEST_APARTMENT = "\tEnter the apartment: ";
    public static final String APARTMENT_INPUT_ERROR = "\tPlease, use only numbers. ";

    /**
     * A constant holding the application introduction.
     */
    public static final String INTRODUCTION = "---== Notebook application ==---";

    /**
     * A constant holding the add request.
     */
    public static final String ADD_REQUEST = "Would you like to add note [Y/N]? ";

    /**
     * A constant holding the one more phone number input request.
     */
    public static final String ONE_MORE_PHONE_NUMBER_REQUEST = "Would you like to add one more mobile phone number [Y/N]? ";

    /**
     * A constant holding the wrong input warning.
     */
    public static final String WRONG_INPUT_VALUE = "Wrong input value. ";

    /**
     * A constant holding the try again message.
     */
    public static final String TRY_AGAIN= "Try again! ";

    /**
     * A constant holding the help additional information.
     */
    public static final String HELP = "If you want to close the input form immediately just type \"stop\"!";

    /**
     * This method outputs the text message to the console
     *
     * @param message - message to output
     */
    public void printMessage(String message){
        System.out.print(message);
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
