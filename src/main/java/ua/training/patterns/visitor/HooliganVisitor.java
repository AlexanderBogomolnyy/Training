package ua.training.patterns.visitor;

/**
 * <p> This class represents visitor with bad manners (hooligan).
 * This class implements visitor interface.
 * This is ConcreteVisitor class from Visitor pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 01.12.2016.
 */
class HooliganVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Started the engine!");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Rapped the body!");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Kicked the " + wheel.getName() + " wheel.");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Smoked inside the car.");
    }

}
