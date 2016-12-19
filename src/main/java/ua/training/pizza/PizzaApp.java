package ua.training.pizza;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * <p> The Pizza application class with main executive method.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 19.12.2016.
 */
public class PizzaApp {

    public static void main(String[] args) {
        // Initializing of price list
        MainPriceList price = new MainPriceList();
        price.addPrice(Ingredient.GOUDA, new BigDecimal(10.50));
        price.addPrice(Ingredient.CORN, new BigDecimal(3.20));
        price.addPrice(Ingredient.CHICKEN, new BigDecimal(20.35));
        price.addPrice(Ingredient.SAUSAGES, new BigDecimal(17.95));
        price.addPrice(Ingredient.TOMATO, new BigDecimal(5.04));
        price.addPrice(Ingredient.CHAMPIGNON, new BigDecimal(12.66));
        price.addPrice(Ingredient.ONION, new BigDecimal(0.95));
        price.addPrice(Ingredient.STANDARD_BASE, new BigDecimal(15.50));

        // Creating order
        SimpleOrder order = new SimpleOrder();
        order.addIngredient(Ingredient.STANDARD_BASE, 1);
        order.addIngredient(Ingredient.GOUDA, 2);
        order.addIngredient(Ingredient.TOMATO, 2);
        order.addIngredient(Ingredient.CHICKEN, 1);
        order.addIngredient(Ingredient.ONION, 1);

        // Decimal format initializing
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);

        // Standard calculation
        Calculator calculator = new PizzaCalculator(price, 0.7);
        order.accept(calculator);
        System.out.println("Standard calculation: " + df.format(calculator.getTotalCost()));

        // Vegetable sale calculation (discount for vegetables 50%)
        Calculator sale = new VegetableSaleCalculator(price, 0.7, 50);
        order.accept(sale);
        System.out.println("Vegetable sale calculation (discount for vegetables 50%): " + df.format(sale.getTotalCost()));
    }

}
