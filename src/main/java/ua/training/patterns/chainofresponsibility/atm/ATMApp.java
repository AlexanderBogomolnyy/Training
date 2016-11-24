package ua.training.patterns.chainofresponsibility.atm;

/**
 * <p> The class imitates ATM performance.
 * The Chain of Responsibility pattern usage example.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
public class ATMApp {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.getMoney(2_870);
        atm.getMoney(10);
        try {
            atm.getMoney(5);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

    }
}
