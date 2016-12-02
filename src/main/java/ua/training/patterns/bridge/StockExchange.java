package ua.training.patterns.bridge;

/**
 * <p> The Stock Exchange class.
 * This class extends abstract class Program.
 * This class represents some kind of computer program for stock exchange.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
public class StockExchange extends Program {

    public StockExchange(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Stock Exchange development in progress...");
        developer.writeCode();
    }
}
