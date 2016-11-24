package ua.training.patterns.chainofresponsibility.atm;

/**
 * <p> The class describes Note Module which is chain link.
 * This abstract class contains common method for all possible chain links.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
abstract class NoteModule {

    private NoteModule next;

    void setNext(NoteModule next) {
        this.next = next;
    }

    public void takeMoney(Money money, StringBuilder operation) {
        int note = getNote();
        int countNote = money.getAmount()/note;
        int remind = money.getAmount()%note;
        if (countNote > 0) {
            operation.append(Note.CURRENCY)
                    .append(note).append(" - ")
                    .append(countNote)
                    .append(" notes; ");
        }
        if (remind > 0 && next != null) {
            next.takeMoney(new Money(remind), operation);
        }
    }

    abstract int getNote();
}
