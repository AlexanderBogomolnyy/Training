package ua.training.textparser.model.entity.note;

import java.util.List;

/**
 * <p> The Note class contains Java code content.
 * This class extends AbstractNote class.
 * This class holds inside the input content with Java code.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 06.12.2016.
 */
public class Code extends AbstractNote {

    /**
     * This field contains a text with Java code
     */
    private String content;

    Code(String content) {
        super();
        this.content = content;
    }

    /**
     * This method sets current note type
     */
    @Override
    protected void initTypes() {
        type = NoteType.CODE;
    }

    @Override
    protected List<Note> parseContent(String input) {
        return null;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Code)) return false;
        if (!super.equals(o)) return false;

        Code code = (Code) o;

        if (!content.equals(code.content)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }
}