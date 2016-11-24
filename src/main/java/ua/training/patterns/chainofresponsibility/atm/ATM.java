package ua.training.patterns.chainofresponsibility.atm;

/**
 * <p> The class represents some behaviour of ATM.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
public class ATM {

    private static final String GRANTED_NEXT_NOTES = "Granted next notes: ";

    /**
     * First note module in chain
     */
    private NoteModule module;

    public ATM() {
        buildChain();
    }

    //builds chain of note modules
    private void buildChain() {
        module = new NoteModule500();
        NoteModule note200 = new NoteModule200();
        NoteModule note100 = new NoteModule100();
        NoteModule note50 = new NoteModule50();
        NoteModule note10 = new NoteModule10();
        module.setNext(note200);
        note200.setNext(note100);
        note100.setNext(note50);
        note50.setNext(note10);
    }

    /**
     * Prints to console information about notes granted from ATM
     *
     * @param amount - requested amount of money
     */
    public void getMoney(int amount) {
        StringBuilder operation = new StringBuilder(GRANTED_NEXT_NOTES);
        module.takeMoney(new Money(amount), operation);
        System.out.println("Requested cash: " + Note.CURRENCY + amount + ". " + operation.toString());
    }
}
