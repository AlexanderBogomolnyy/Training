package ua.training.textparser.model.entity.note;

import java.util.regex.Pattern;

/**
 * <p> This interface constants for regular expressions.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.12.2016.
 */
interface RegEx {
    /**
     * A constant holding pattern for splitting text to paragraphs
     */
    Pattern PARAGRAPH_PATTERN = Pattern.compile("(\\r?\\n{2,}\\t?)|($)");

    /**
     * A constant holding pattern for extracting Java code
     */
    Pattern CODE_PATTERN = Pattern.compile("\\t?\\n(pacage|import|public|protected|private|static|abstract|final|void|class)");

    /**
     * A constant holding pattern for splitting paragraph to sentences
     */
    Pattern SENTENCE_PATTERN = Pattern.compile("((\\.|\\!|\\?)+[ \\n$]?)|($)");

    /**
     * A constant holding pattern for splitting sentence to words
     */
    Pattern WORD_PATTERN = Pattern.compile("([\\s\\n,\\.!\\?:;\\(\\)])|($)");
}
