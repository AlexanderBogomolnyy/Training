package ua.training.textparser.model.entity.note;

import java.util.*;
import java.util.regex.Matcher;

/**
 * <p> The abstract note class.
 * This class implements Note interface and provides common implementations for interface
 * methods.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 05.12.2016.
 */
abstract class AbstractNote implements Note {

    /**
     * A constant holding the message about lack of child notes
     */
    private static final String NO_CHILDREN = "This Note does not have children.";

    /**
     * A constant holding the message about unsupported child note
     */
    private static final String UNSUPPORTED_CHILD = "Unsupported child note.";

    /**
     * List of children
     */
    private List<Note> notes;

    /**
     * Type of current Note
     */
    protected NoteType type;

    /**
     * List of supported children
     */
    protected Set<NoteType> supportedNotes = new HashSet<>();

    /**
     * Note factory
     */
    final NoteFactory factory = NoteFactory.getInstance();

    protected AbstractNote() {
        initContainer();
        initTypes();
    }

    protected AbstractNote(String input) {
        Objects.requireNonNull(input);
        initContainer();
        initTypes();
        addNotes(parseContent(input));
    }

    /**
     * This method initialized default values of class fields
     */
    protected void initContainer() {
        this.notes = new ArrayList<>();
    }

    /**
     * This method sets current note type, and types of supported children
     */
    protected abstract void initTypes();

    /**
     * This method returns Type of current Note
     *
     * @return type of note
     */
    @Override
    public NoteType getType() {
        return type;
    }

    @Override
    public boolean hasChildNotes() {
        return notes != null && !notes.isEmpty();
    }

    @Override
    public List<Note> getChildNotes() {
        if (hasChildNotes()) return notes;
        throw new NoSuchElementException(NO_CHILDREN);
    }

    @Override
    public String getContent() {
        StringBuilder builder = new StringBuilder();
        notes.stream().map(Note::getContent).forEach(builder::append);
        return builder.toString();
//        return this.getClass().getSimpleName().substring(0,2) + "{" + builder.toString()+"}";
    }

    @Override
    public List<Note> getNoteTree() {
        List<Note> result = new ArrayList<>();
        getTree(this, result);
        return result;
    }

    // This method builds Note tree recursively
    private void getTree(Note current, List<Note> result) {
        if (current.hasChildNotes()) {
            List<Note> children = current.getChildNotes();
            for(Note child: children)
                getTree(child, result);
        }
        result.add(current);
    }

    /**
     * This method adds single Note to this note container
     *
     * @param note - some object, which implements Note interface
     */
    void addNote(Note note){
        if (!supportedNotes.contains(note.getType()))
            throw new UnsupportedClassVersionError(UNSUPPORTED_CHILD);
        notes.add(note);
    }

    /**
     * This method adds list of Note to this note container
     *
     * @param list - list of some object, any of which implements Note interface
     */
    void addNotes(List<Note> list) {
        list.stream().forEach(this::addNote);
    }

    /**
     * This method parse input text to child notes for current note.
     *
     * @param input - input text
     * @return - list of components
     */
    abstract List<Note> parseContent(String input);

    /**
     * This method adds separator to the result list utilizing matcher for search
     *
     * @param input - input text
     * @param result - result list of notes
     * @param matcher - separator matcher
     */
    void addSeparator(String input, List<Note> result, Matcher matcher) {
        String separator = input.substring(matcher.start(), matcher.end());
        if (!separator.isEmpty())
            addSigns(separator, result);
    }

    /**
     * This method convert input string to char sequence and adds each of them
     * into the list of notes
     *
     * @param input - input string
     * @param note - note list for adding string notes
     */
    void addSigns(String  input, List<Note> note) {
        for (char ch : input.toCharArray())
            note.add(factory.getSign(ch));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractNote)) return false;
        AbstractNote that = (AbstractNote) o;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (type != that.type) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = notes != null ? notes.hashCode() : 0;
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + getContent() + "}";
    }
}
