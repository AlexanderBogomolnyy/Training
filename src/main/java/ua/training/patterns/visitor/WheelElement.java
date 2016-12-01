package ua.training.patterns.visitor;

/**
 * <p> This class represents car wheel.
 * This class implements Element interface.
 * This is ConcreteElement class from Visitor pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 01.12.2016.
 */
class WheelElement implements Element {
    private String name;

    public WheelElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
