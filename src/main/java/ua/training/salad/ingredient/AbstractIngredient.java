package ua.training.salad.ingredient;

/**
 * <p> The abstract ingredient class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.12.2016.
 */
abstract class AbstractIngredient implements Ingredient {

    /**
     * The ingredient type
     */
    private IngredientType type;

    /**
     * the ingredient size
     */
    private int size;

    public AbstractIngredient(IngredientType type, int size) {
        this.type = type;
        this.size = size;
    }

    /**
     * This method returns current ingredient type
     *
     * @return type of current ingredient
     */
    @Override
    public IngredientType getIngredientType() {
        return type;
    }

    /**
     * This method cuts ingredient for pieces
     *
     * @return array of ingredient pieces
     */
    @Override
    public IngredientPiece[] cut() {
        IngredientPiece[] pieces = new IngredientPiece[size];
        for(int i = 0; i < pieces.length; i++) {
            pieces[i] = new IngredientPiece(this);
        }
        return pieces;
    }

}
