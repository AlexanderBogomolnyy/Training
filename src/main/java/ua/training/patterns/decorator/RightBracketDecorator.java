package ua.training.patterns.decorator;

/**
 * <p> The Decorator class for Printer Interface.
 * This class extends abstract Decorator..
 * This class adds bracket in the end of component output.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
class RightBracketDecorator extends Decorator {

    public RightBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        super.print();
        System.out.print("]");
    }
}
