package ua.training.patterns.decorator;

/**
 * <p> The Decorator class for Printer Interface.
 * This class extends abstract Decorator..
 * This class adds quotes to the both sides of component output.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
class QuotesDecorator extends Decorator {

    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}
