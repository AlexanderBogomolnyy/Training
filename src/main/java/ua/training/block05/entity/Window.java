package ua.training.block05.entity;

import ua.training.block05.model.FieldMarker;
import ua.training.block05.model.Run;

/**
 * <p> The class describing some kind of window.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 08.11.2016.
 */

public class Window {

    public static final int DEFAULT_LEFT = 20;
    public static final int DEFAULT_RIGHT = 20;
    public static final int DEFAULT_TOP = 40;
    public static final int DEFAULT_BOTTOM = 40;
    public static final int DEFAULT_COLOR = 0xffff00ff;

    private int left;
    private int top;
    private int right;
    private int bottom;

    @FieldMarker
    private int color;

    public Window() {
    }

    public Window(int left, int top, int right, int bottom, int color) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.color = color;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Window)) return false;

        Window window = (Window) o;

        if (bottom != window.bottom) return false;
        if (color != window.color) return false;
        if (left != window.left) return false;
        if (right != window.right) return false;
        if (top != window.top) return false;

        return true;
    }

    @Run(enable = false)
    @Override
    public int hashCode() {
        int result = left;
        result = 31 * result + top;
        result = 31 * result + right;
        result = 31 * result + bottom;
        result = 31 * result + color;
        return result;
    }

    @Run(enable = true)
    @Override
    public String toString() {
        return "Window{" +
                "left=" + left +
                ", top=" + top +
                ", right=" + right +
                ", bottom=" + bottom +
                ", color=" + color +
                '}';
    }
}
