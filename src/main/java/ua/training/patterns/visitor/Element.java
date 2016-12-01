package ua.training.patterns.visitor;

/**
 * <p> This interface describes some kind of automobile part.
 * This is Element interface from Visitor pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 01.12.2016.
 */
interface Element {
    void accept(Visitor visitor);
}
