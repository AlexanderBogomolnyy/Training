package ua.training.salad;

import ua.training.salad.ingredient.Cucumber;
import ua.training.salad.ingredient.Radish;
import ua.training.salad.ingredient.Tomato;
import ua.training.salad.saladdressing.Olive;

/**
 * <p> The Runner class with main executive method.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.12.2016.
 */
public class SaladApp {

    public static void main(String[] args) {
        SaladBuilder builder = new SaladBuilder();
        Salad salad = builder.build();
        if (salad == null)
            salad = builder.addIngredient(new Tomato(2))
                    .addIngredient(new Cucumber(3))
                    .addIngredient(new Radish(2)).build();
        if (salad == null)
            salad = builder.addSaladDressing(new Olive(2)).build();
        salad.viewSalad();
    }

}
