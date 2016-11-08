package ua.training.block04.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p> The validation class
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.11.2016.
 */
public class Validator {

    /**
     * The pattern containing regular expression
     */
    private Pattern pattern;

    /**
     * The validation error message string
     */
    private String errorMessage;

    /**
     * The validation stage of last checked value
     */
    private boolean isLastValueValid;

    public Validator(Pattern pattern, String errorMessage) {
        this.pattern = pattern;
        this.errorMessage = errorMessage;
    }

    /**
     * This method checks input string for compliance to validation rule.
     *
     * @param value - string for validation
     * @return - true if input value valid
     *           false in other case
     */
    public boolean isValid(String value) {
        Matcher matcher = pattern.matcher(value);
        isLastValueValid = matcher.matches();
        return isLastValueValid;
    }

    /**
     * This method should be called after {@link Validator#isValid(String)}.
     * If method {@link Validator#isValid(String)} returns false, this method returns
     * error message, in opposite way - returns null.
     *
     * @return - error message or null
     */
    public String getErrorMessage() {
        return isLastValueValid ? null : errorMessage;
    }
}
