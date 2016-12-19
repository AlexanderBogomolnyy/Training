package ua.training.pizza;

import java.math.BigDecimal;
import java.util.Map;

/**
 * <p> The VegetableSaleCalculator class.
 * This class implements calculator interface.
 * This class calculates total cost of order with pizzeria profit, and considering
 * discount for vegetables.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 19.12.2016.
 */
public class VegetableSaleCalculator implements Calculator {

    /**
     * Value of profit
     */
    private double profit;

    /**
     * Discount value
     */
    private BigDecimal discount;

    /**
     * Order total cost
     */
    private BigDecimal totalCost = new BigDecimal(0);

    /**
     * Price list for calculating
     */
    private PriceList priceList;

    public VegetableSaleCalculator(PriceList priceList, double profit, int discountPercent) {
        this.priceList = priceList;
        this.profit = profit;
        this.discount = new BigDecimal(1 - (double)discountPercent/100);
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
     * This method calculates the order total cost considering discount
     * for vegetables.
     *
     * @param order order for pizza
     */
    @Override
    public void calculate(Order order) {
        Map<Ingredient, Integer> ingredients = order.getIngredients();
        BigDecimal cost = new BigDecimal(0);
        for(Map.Entry<Ingredient, Integer> entry: ingredients.entrySet()) {
            Ingredient currentIngredient = entry.getKey();
            BigDecimal currentPrice = priceList.getPrice(currentIngredient);
            if(currentIngredient.getCategory() == Category.VEGETABLE) {
                currentPrice = currentPrice.multiply(discount);
            }
            cost = cost.add(currentPrice.multiply(new BigDecimal(entry.getValue())));
        }
        totalCost = cost.multiply(new BigDecimal(1 + profit));
    }

}
