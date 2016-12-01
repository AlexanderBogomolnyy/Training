package ua.training.patterns.visitor;

/**
 * <p> This class represents car mechanic.
 * This class implements visitor interface.
 * This is ConcreteVisitor class from Visitor pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 01.12.2016.
 */
class MechanicVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Checked the engine!");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Polished the body!");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Pumped up the " + wheel.getName() + " wheel.");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Checked the appearance of the car.");
    }

}
