package ua.training.salad.ingredient;

/**
 * <p> The Ingredient interface.
 * This interface provides method for some kind of salad ingredient
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.12.2016.
 */
public interface Ingredient {

    /**
     * This method returns current ingredient type
     *
     * @return the type of current ingredient
     */
    IngredientType getIngredientType();

    /**
     * This method cuts ingredient for pieces
     *
     * @return array of ingredient pieces
     */

    IngredientPiece[] cut();
}
