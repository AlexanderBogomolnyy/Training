package ua.training.block05.entity;

import ua.training.block05.model.ClassMarker;
import ua.training.block05.model.FieldMarker;
import ua.training.block05.model.Run;

import java.io.Serializable;

/**
 * <p> The text window class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 08.11.2016.
 */
@ClassMarker
public final class TextWindow extends Window implements Serializable {

    private String text;

    @FieldMarker
    private int textColor;

    public TextWindow() {
        super();
    }

    public TextWindow(int left, int top, int right, int bottom, int color, String text, int textColor) {
        super(left, top, right, bottom, color);
        this.text = text;
        this.textColor = textColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextWindow)) return false;
        if (!super.equals(o)) return false;

        TextWindow that = (TextWindow) o;

        if (textColor != that.textColor) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Run(enable = false)
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + textColor;
        return result;
    }

    @Run(enable = true)
    @Override
    public String toString() {
        return "TextWindow{" +
                "text='" + text + '\'' +
                ", textColor=" + textColor +
                '}';
    }
}
