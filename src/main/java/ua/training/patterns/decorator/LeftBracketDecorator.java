package ua.training.patterns.decorator;

/**
 * <p> The Decorator class for Printer Interface.
 * This class extends abstract Decorator.
 * This class adds bracket in front of component output.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
class LeftBracketDecorator extends Decorator {

    public LeftBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("[");
        super.print();
    }
}
