package ua.training.patterns.bridge;

/**
 * <p> The Program class.
 * This abstract class represents some kind of computer program.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 02.12.2016.
 */
public abstract class Program {
    protected Developer developer;

    protected Program(Developer developer) {
        this.developer = developer;
    }

    public abstract void developProgram();
}
