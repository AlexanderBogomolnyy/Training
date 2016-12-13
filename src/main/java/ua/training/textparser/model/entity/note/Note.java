package ua.training.textparser.model.entity.note;

import java.util.List;

/**
 * <p> The text note interface.
 * This interface provides methods for building tree of contained elements for text.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.12.2016.
 */
public interface Note {
    /**
     * This method returns Type of current Note
     *
     * @return type of note
     */
    NoteType getType();

    /**
     * This method checks if Note has child notes in its container
     *
     * @return true if Node has children, false in opposite case
     */
    boolean hasChildNotes();

    /**
     * This method returns list of child notes for current Note
     *
     * @return list of notes
     */
    List<Note> getChildNotes();

    /**
     * This method returns content of current note as String value
     *
     * @return - String content
     */
    String getContent();

    /**
     * This method returns Tree of notes including its children as single list
     *
     * @return list of notes
     */
    List<Note> getNoteTree();

}
