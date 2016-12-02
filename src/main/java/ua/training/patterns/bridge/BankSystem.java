package ua.training.patterns.bridge;

/**
 * <p> The Bank System class.
 * This class extends abstract class Program.
 * This class represents some kind of computer program for bank.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
public class BankSystem extends Program {

    public BankSystem(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Bunk System development in progress...");
        developer.writeCode();
    }
}
