package ua.training.patterns.decorator;

/**
 * <p> The abstract Decorator class for Printer Interface.
 * This class implements Printer Interface
 * This class provides the same field and methods for all Decorators.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
abstract class Decorator implements PrinterInterface {
    private PrinterInterface component;

    public Decorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        component.print();
    }
}
