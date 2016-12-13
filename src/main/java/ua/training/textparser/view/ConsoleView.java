package ua.training.textparser.view;

import java.util.Collection;
import java.util.Iterator;

/**
 * <p> The input form view class.
 * It represents the console view of input form.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 09.12.2016.
 */
public class ConsoleView {

    /**
     * A constant holding the application introduction.
     */
    public static final String INTRODUCTION = "---== Text Parser ==---";

    /**
     * A constant holding the data loading exception information.
     */
    public static final String DATA_LOADING_EXCEPTION = "Data have not loaded.";

    /**
     * A constant holding the information message about search statistics
     */
    public static final String WORDS_FOR_SEARCH = "There is a search for unitary occupation of next words: ";

    /**
     * A constant holding the information message about single words in text
     */
    public static final String SEARCH_STATISTICS = "Next words of first sentence were found in text only once : ";

    /**
     * A constant holding the information message about empty first sentence
     */
    public static final String EMPTY_SENTENCE_EXCEPTION = "First sentence is empty. Search didn't complete. ";

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
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (iterator.hasNext()) {
                System.out.print(next.toString() + ", ");
            } else {
                System.out.println(next.toString());
            }
        }
    }
}
