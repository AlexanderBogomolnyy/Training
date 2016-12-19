package ua.training.pizza;

import java.math.BigDecimal;

/**
 * <p> The PriceList interface.
 * This interface provides methods for getting ingredient prices.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 19.12.2016.
 */
public interface PriceList {

    /**
     * This method return price by ingredient
     *
     * @param ingredient - some kind of ingredient
     * @return ingredient price
     */
    BigDecimal getPrice(Ingredient ingredient);
}
