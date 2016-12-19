package ua.training.pizza;

import java.util.Map;

/**
 * <p> The Order interface.
 * This interface provides methods for getting order information and setting
 * cost calculator.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 19.12.2016.
 */
public interface Order {

    /**
     * This method returns order ingredients map
     *
     * @return - Map of ingredients withe their amounts
     */
    Map<Ingredient, Integer> getIngredients();

    /**
     * This method accepts calculator for order
     *
     * @param calculator - order calculator
     */
    void accept(Calculator calculator);

}
