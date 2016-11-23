package ua.training.patterns.decorator;

/**
 * <p> The Decorator (Wrapper) pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
public class DecoratorApp {

    public static void main(String[] args) {
//        PrinterInterface printer = new Printer("Hello");
//        PrinterInterface printer = new QuotesDecorator(new Printer("Hello"));
//        PrinterInterface printer = new LeftBracketDecorator(new Printer("Hello"));
//        PrinterInterface printer = new QuotesDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hello"))));
        PrinterInterface printer = new QuotesDecorator(new RightBracketDecorator(new LeftBracketDecorator(new Printer("Hello"))));
        printer.print();
    }

}
