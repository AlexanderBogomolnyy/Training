package ua.training.patterns.bridge;

/**
 * <p> The Bridge pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
public class BridgeApp {
    public static void main(String[] args) {
//        Program[] programs = {
//                new BankSystem(new JavaDeveloper()),
//                new StockExchange(new CppDeveloper())
//        };
        Program[] programs = {
                new BankSystem(new CppDeveloper()),
                new StockExchange(new JavaDeveloper())
        };
        for(Program program: programs) {
            program.developProgram();
        }
    }
}
