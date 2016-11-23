package ua.training.patterns.decorator;

/**
 * <p> The class implements Printer Interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 23.11.2016.
 */
class Printer implements PrinterInterface {

    private String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}
