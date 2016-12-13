package ua.training.textparser.model.entity.note;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> The Note class contains text word.
 * This class extends AbstractNote class.
 * This class holds inside the list of word notes.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 06.12.2016.
 */
public class Word extends AbstractNote {

    Word(String content) {
        super(content);
    }

    /**
     * This method sets current note type, and types of supported children
     */
    @Override
    protected void initTypes() {
        this.type = NoteType.WORD;
        supportedNotes.add(NoteType.SIGN);
    }

    /**
     * This method builds tree of child notes.
     *
     * @param input input String content
     * @return - list of notes
     */
    @Override
    protected List<Note> parseContent(String input) {
        List<Note> result = new ArrayList<>();
        addSigns(input, result);
        return result;
    }
}
