package ua.training.patterns.chainofresponsibility.atm;

/**
 * <p> The class implements real note module for note worth 50 UAH.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
class NoteModule50 extends NoteModule {
    @Override
    int getNote() {
        return Note.UAH50;
    }
}