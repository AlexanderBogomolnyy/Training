package ua.training.block04.controller;

import ua.training.block04.model.Group;

import java.util.regex.Pattern;

/**
 * <p> This interface provides regular expressions for fields of note's input form.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.11.2016.
 */
public interface FormValidationRegexes {

    // Input form validation patterns
    public static final Pattern NAME = Pattern.compile("([A-Z]{1}[a-z]{1,30}[- ]{0,1}|[A-Z]{1}[- \\']{1}[A-Z]{0,1}[a-z]{1,30}[- ]{0,1}|[a-z]{1,2}[ -\\']{1}[A-Z]{1}[a-z]{1,30}){1,5}");
    public static final Pattern NICKNAME = Pattern.compile("^[a-z0-9_-]{3,15}$");
    public static final Pattern COMMENT = Pattern.compile(".+");
    public static final Pattern GROUP = Pattern.compile(noteGroupEnumPattern());
    public static final Pattern HOME_PHONE_NUMBER = Pattern.compile("(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]\u200C\u200B)\\s*)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)([2-9]1[02-9]\u200C\u200B|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})\\s*(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+)\\s*)?$");
    public static final Pattern MOBILE_PHONE_NUMBER = Pattern.compile("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$");
    public static final Pattern EMAIL = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    public static final Pattern MESSENGER = Pattern.compile("^[a-z0-9_-]{3,15}$");
    public static final Pattern ZIP_CODE = Pattern.compile("^\\d{5}(?:[-\\s]\\d{4})?$");
    public static final Pattern CITY_NAME = Pattern.compile("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$");
    public static final Pattern STREET_NAME = Pattern.compile("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$");
    public static final Pattern BUILDING_NUMBER = Pattern.compile("^[0-9]{1,4}\\w+");
    public static final Pattern APARTMENT_NUMBER = Pattern.compile("^[0-9]{1,4}");

    /**
     * Generate string value of pattern containing all Group enum values
     *
     * @return - string value of pattern containing all Group enum values
     */
    static String noteGroupEnumPattern() {
        StringBuilder builder = new StringBuilder();
        builder.append("(?i)(");
        for(Group value: Group.values()) {
            builder.append(value.name()).append("|");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(")");
        return builder.toString();
    }
}
