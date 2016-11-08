package ua.training.block04.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> The notebook class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.11.2016.
 */
public class Notebook {

    /**
     * The list contains notebook's notes.
     */
    private List<Note> notes;

    /**
     * The constructor without parameters
     */
    public Notebook() {
        notes = new ArrayList<>();
    }

    /**
     * This method adds note to the notebook.
     *
     * @param note - some note, which will be added to the notebook's list
     */
    public void addNote(Note note) {
        notes.add(note);
    }

    /**
     * This method returns the list of notebook's notes.
     *
     * @return - the list of notebook's notes.
     */
    public List<Note> getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Notebook{\n");
        for(Note note: notes)
            builder.append(note.toString());
        builder.append("\n}");
        return builder.toString();
    }
}
