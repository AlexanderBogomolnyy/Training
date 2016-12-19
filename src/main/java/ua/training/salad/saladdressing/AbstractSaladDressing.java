package ua.training.salad.saladdressing;

/**
 * <p> The abstract salad dressing class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.12.2016.
 */
abstract class AbstractSaladDressing implements SaladDressing {

    /**
     * The salad dressing type
     */
    private SaladDressingType type;

    /**
     * The salad dressing quantity
     */
    private int quantity;

    public AbstractSaladDressing(SaladDressingType type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    /**
     * This method returns current salad dressing type
     *
     * @return the type of current salad dressing
     */
    @Override
    public SaladDressingType getSaladDressingType() {
        return type;
    }
}
