package ua.training.pizza;

import java.math.BigDecimal;

/**
 * <p> The Calculation interface.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 19.12.2016.
 */
public interface Calculator {

    /**
     * This method returns order total cost
     *
     * @return total cost
     */
    BigDecimal getTotalCost();

    /**
     * This method calculates the order total cost
     *
     * @param order order for pizza
     */
    void calculate(Order order);
}
