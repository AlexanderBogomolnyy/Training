package ua.training.patterns.visitor;

/**
 * <p> This interface describes some kind of Visitor.
 * This is Visitor interface from Visitor pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 01.12.2016.
 */
interface Visitor {
    void visit(EngineElement engine);
    void visit(BodyElement body);
    void visit(WheelElement wheel);
    void visit(CarElement car);
}
