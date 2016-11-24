package ua.training.patterns.chainofresponsibility.atm;

/**
 * <p> The interface provides some static Note characteristics.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
interface Note {
    public static final Character CURRENCY = '\u20b4';
    public static final int UAH500 = 500;
    public static final int UAH200 = 200;
    public static final int UAH100 = 100;
    public static final int UAH50 = 50;
    public static final int UAH10 = 10;

}
