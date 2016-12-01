package ua.training.patterns.visitor;

/**
 * <p> This class represents some kind of car.
 * This class implements Element interface.
 * This is ConcreteElement class from Visitor pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 01.12.2016.
 */
class CarElement implements Element {

    private Element[] elements;

    public CarElement() {
        this.elements = new Element[] { new WheelElement("forward left"),
            new WheelElement("forward right"), new WheelElement("rear left"),
            new WheelElement("rear right"), new BodyElement(), new EngineElement()
        };
    }

    @Override
    public void accept(Visitor visitor) {
        // calling accept(visitor) at each element in the array of elements
        for(Element element: elements) {
            element.accept(visitor);
        }
        visitor.visit(this);
    }
}
