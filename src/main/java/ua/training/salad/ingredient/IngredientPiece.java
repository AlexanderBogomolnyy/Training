package ua.training.salad.ingredient;

/**
 * <p> The Ingredient piece class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.12.2016.
 */
public class IngredientPiece {

    /**
     * The ingredient
     */
    private Ingredient ingredient;

    public IngredientPiece(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    /**
     * This method returns ingredient piece type
     *
     * @return the type of current ingredient piece
     */
    public IngredientType getType() {
        return ingredient.getIngredientType();
    }

}
