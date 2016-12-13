package ua.training.textparser.model.entity.note;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/**
 * <p> The Note Factory class.
 * This is singleton class. It provides methods for getting different
 * kinds of classes, which implement Note interface.
 * There is two getting resources methods.
 * One for returning Note by Type from String context and another for
 * returning Note from Character.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.12.2016.
 */
public class NoteFactory {

    /**
     * A constant holding the message about illegal argument as text content
     */
    private static final String ILLEGAL_ARGUMENT_EXCEPTION = "Cannot cash such note.";

    /**
     * A constant holding the message about illegal Note Type
     */
    private static final String ILLEGAL_TYPE_EXCEPTION = "Cannot create note of such type.";

    /**
     * A constant holding the message about unsupported Note Type for cashing
     */
    private static final String UNSUPPORTED_TYPE_FOR_CASH = "Type: %s does not support by the cash.";

    /**
     * Hash map for cashing note by string key
     */
    private Map<String, Note> generalCash = new WeakHashMap<>();

    /**
     * Hash map for cashing note by char key
     */
    private Map<Character, Note> charCash = new WeakHashMap<>();

    /**
     * Static initialization of factory instance
     */
    private static NoteFactory instance = new NoteFactory();

    /**
     * Private empty constructor
     */
    private NoteFactory() {
    }

    /**
     * This method returns factory instance
     *
     * @return factory instance
     */
    public static NoteFactory getInstance() {
        return instance;
    }

    /**
     * This method returns Note by Type for string context
     *
     * @param text - text content
     * @param type - Note Type
     * @return - new Note
     */
    public Note getNote(String text, NoteType type) {
        Objects.requireNonNull(text);
        if (text.isEmpty()) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_EXCEPTION);
        }
        Note result;
        switch (type) {
            case DOCUMENT:
                result = new Document(text);
                break;
            case PARAGRAPH:
                result = new Paragraph(text);
                break;
            case SENTENCE:
                result = new Sentence(text);
                break;
            case CODE:
                result = new Code(text);
                break;
            case WORD:
                result = getCashingNote(text, type);
                break;
            default:
                throw new IllegalArgumentException(ILLEGAL_TYPE_EXCEPTION);
        }
        return result;
    }

    // Method for creating Note through cash
    private Note getCashingNote(String text, NoteType type) {
        String key = text + type.name();
        if (generalCash.containsKey(key)) {
            return generalCash.get(key);
        } else {
            Note result;
            switch (type) {
                case WORD:
                    result = new Word(text);
                    break;
                default:
                    throw new IllegalArgumentException(String.format(UNSUPPORTED_TYPE_FOR_CASH, type.name()));
            }
            generalCash.put(key, result);
            return result;
        }
    }

    /**
     * This method returns Sign note for char
     *
     * @param value - context
     * @return - new Note
     */
    public Note getSign(char value) {
        if (charCash.containsKey(value)) {
            return charCash.get(value);
        }
        Note newSign = new Sign(value);
        charCash.put(value, newSign);
        return newSign;
    }

}
