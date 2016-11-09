package ua.training.block05.view;

import java.util.ArrayList;

/**
 * <p> The console view class.
 * It represents the console view of data.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 08.11.2016.
 */
public class View {

    // Title constants
    public static final String CONSTRUCTORS = "--------------------- Class constructors --------------------";
    public static final String CLASS_MODIFIERS = "----------------------- Class modifiers ---------------------";
    public static final String METHODS_WITH_ANNOTATIONS_AND_PARAMETERS = "---------- Methods with annotations and parameters ----------";
    public static final String CLASS_AND_PACKAGE_NAME = "------------------ Class and package name -------------------";
    public static final String METHODS_WITH_ACCESS_MODIFIERS_AND_PARAMETERS = "-------- Methods with access modifiers and parameters -------";
    public static final String SUPER_CLASS_NAME = "----------------------- Super class -------------------------";
    public static final String FIELDS_WITH_PARAMETERS_AND_ACCESS_MODIFIERS = "----- Class fields with parameters and access modifiers -----";
    public static final String CLASS_ANNOTATIONS = "--------------------- Class annotations ---------------------";
    public static final String CLASS_INTERFACES = "---------------------- Class interfaces ---------------------";
    public static final String FIELDS_WITH_PARAMETERS_AND_ANNOTATIONS = "------- Class fields with parameters and annotations --------";
    public static final String INVOKE_ANNOTATED = "------------ Call all annotated by @Run methods -------------";

    /**
     * A constant holding the application introduction.
     */
    public static final String INTRODUCTION = "----------------==== Meta data analyzing ====----------------";

    /**
     * A constant holding the divider.
     */
    public static final String DIVIDER = "=============================================================";

    /**
     * This method outputs the text message to the console
     *
     * @param message - message to output
     */
    public void printMessage(String message){
        System.out.print(message);
    }

    /**
     * This method outputs the text message to the console and feeds the line
     *
     * @param message - message to output
     */
    public void printlnMessage(String message){
        System.out.println(message);
    }

    /**
     * This method outputs the array of strings to the console, each string from te new line
     *
     * @param message - array of strings to output
     */
    public void printlnMessage(String[] message){
        for (String string: message)
            System.out.println(string);
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
