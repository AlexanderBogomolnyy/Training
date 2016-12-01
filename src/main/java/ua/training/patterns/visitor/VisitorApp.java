package ua.training.patterns.visitor;

/**
 * <p> The Visitor pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 01.12.2016.
 */
public class VisitorApp {
    public static void main(String[] args) {
//        Element bony = new BodyElement();
//        Element engine = new EngineElement();
////        Visitor visitor = new HooliganVisitor();
//        Visitor visitor = new MechanicVisitor();
//
//        bony.accept(visitor);
//        engine.accept(visitor);

        Element car = new CarElement();
        car.accept(new HooliganVisitor());
        System.out.println();
        car.accept(new MechanicVisitor());
    }
}
