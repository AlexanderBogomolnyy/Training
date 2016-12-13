package ua.training.textparser.model.entity.note;

import java.util.List;

/**
 * <p> The Note class contains single sign.
 * This class extends AbstractNote class.
 * This class holds inside the char content with one sign.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 06.12.2016.
 */
public class Sign extends AbstractNote {

    /**
     * This field contains a text sign
     */
    private char sign;

    Sign(char sign) {
        super();
        this.sign = sign;
    }

    /**
     * This method sets current note type
     */
    @Override
    protected void initTypes() {
        this.type = NoteType.SIGN;
    }

    @Override
    List<Note> parseContent(String input) {
        return null;
    }

    @Override
    public String getContent() {
        return String.valueOf(sign);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sign)) return false;
        if (!super.equals(o)) return false;

        Sign sign1 = (Sign) o;

        if (sign != sign1.sign) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) sign;
        return result;
    }
}
