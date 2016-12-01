package ua.training.patterns.visitor;

/**
 * <p> This class represents car body.
 * This class implements Element interface.
 * This is ConcreteElement class from Visitor pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 01.12.2016.
 */
class BodyElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
