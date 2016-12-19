package ua.training.pizza;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> The SimpleOrder class.
 * This class implements Order interface.
 * This class provides methods for forming order for pizza.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 19.12.2016.
 */
public class SimpleOrder implements Order {

    /**
     * The Map of ingredient for pizza with their amount
     */
    private Map<Ingredient, Integer> ingredients = new HashMap<>();

    /**
     * This method adds ingredient to the pizza order
     *
     * @param ingredient - some kind of ingredient
     * @param amount - amount of added ingredient
     */
    public void addIngredient(Ingredient ingredient, int amount) {
        ingredients.put(ingredient, amount);
    }

    /**
     * This method removes ingredient from the Map of ingredients
     *
     * @param ingredient - some kind of ingredient
     */
    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    /**
     * This method returns order ingredients map
     *
     * @return - Map of ingredients withe their amounts
     */
    @Override
    public Map<Ingredient, Integer> getIngredients() {
        return ingredients;
    }

    /**
     * This method accepts calculator for order
     *
     * @param calculator - order calculator
     */
    @Override
    public void accept(Calculator calculator) {
        calculator.calculate(this);
    }
}
