package ua.training.pizza;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * <p> The MainPriceList class.
 * This class provides methods for storing information about available ingredients
 * and their prices.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 19.12.2016.
 */
public class MainPriceList implements PriceList {

    /**
     * Map of ingredients anf their prices
     */
    Map<Ingredient, BigDecimal> prices = new HashMap<>();

    /**
     * This method adds ingredient to the price map
     *
     * @param ingredient - some kind of ingredient
     * @param price - its price
     */
    public void addPrice(Ingredient ingredient, BigDecimal price) {
        prices.put(ingredient, price);
    }

    /**
     * This method remove ingredient from the price map
     *
     * @param ingredient - some kind of ingredient
     */
    public void removePrice(Ingredient ingredient) {
        prices.remove(ingredient);
    }

    /**
     * This method return price by ingredient
     *
     * @param ingredient - some kind of ingredient
     * @return ingredient price
     */
    @Override
    public BigDecimal getPrice(Ingredient ingredient) {
        if (prices.containsKey(ingredient)) {
            return prices.get(ingredient);
        }
        throw new IllegalArgumentException("This ingredient does not present in price list");
    }
}
