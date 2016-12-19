package ua.training.pizza;

import java.math.BigDecimal;
import java.util.Map;

/**
 * <p> The PizzaCalculator class.
 * This class implements calculator interface.
 * This class calculates total cost of order with pizzeria profit.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 19.12.2016.
 */
public class PizzaCalculator implements Calculator {

    /**
     * Value of profit
     */
    private double profit;

    /**
     * Order total cost
     */
    private BigDecimal totalCost = new BigDecimal(0);

    /**
     * Price list for calculating
     */
    private PriceList priceList;

    public PizzaCalculator(PriceList priceList, double profit) {
        this.priceList = priceList;
        this.profit = profit;
    }

    /**
     * This method returns order total cost
     *
     * @return total cost
     */
    @Override
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    /**
     * This method calculates the order total cost
     *
     * @param order order for pizza
     */
    @Override
    public void calculate(Order order) {
        Map<Ingredient, Integer> ingredients = order.getIngredients();
        BigDecimal cost = new BigDecimal(0);
        for(Map.Entry<Ingredient, Integer> entry: ingredients.entrySet()) {
            cost = cost.add(priceList.getPrice(entry.getKey()).multiply(new BigDecimal(entry.getValue())));
        }
        totalCost = cost.multiply(new BigDecimal(1 + profit));
    }
}
