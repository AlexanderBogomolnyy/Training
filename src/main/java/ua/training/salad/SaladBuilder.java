package ua.training.salad;

import ua.training.salad.ingredient.Ingredient;
import ua.training.salad.ingredient.IngredientPiece;
import ua.training.salad.saladdressing.SaladDressing;

import java.util.*;

/**
 * <p> The Salad Builder class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.12.2016.
 */
public class SaladBuilder {

    /**
     * The list of salad ingredients
     */
    private List<Ingredient> ingredients = new ArrayList<>();

    /**
     * The salad dressing
     */
    private SaladDressing saladDressing;

    /**
     * This method adds salad ingredient to the list of ingredients
     *
     * @param ingredient - salad ingredient
     * @return - reference for current builder
     */
    public SaladBuilder addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
        return this;
    }

    /**
     * This method adds salad dressing
     *
     * @param saladDressing - salad dressing
     * @return - reference to current builder
     */
    public SaladBuilder addSaladDressing(SaladDressing saladDressing) {
        this.saladDressing = saladDressing;
        return this;
    }

    /**
     * This method builds salad utilizing list of salad ingredients and
     * salad dressing. This method cuts ingredients and shuffles them before
     * adding to the salad.
     *
     * @return new salad or null, if salad could not be prepared with present components
     */
    public Salad build() {
        if (ingredients.isEmpty()) {
            System.out.println("Add ingredients at first.");
            return null;
        }
        if (saladDressing == null) {
            System.out.println("Add salad dressing at first.");
            return null;
        }

        List<IngredientPiece> ingredientPieces = new LinkedList<>();
        for(Ingredient ingredient: ingredients)
            ingredientPieces.addAll(Arrays.asList(ingredient.cut()));  //ingredient cutting

        Collections.shuffle(ingredientPieces);   // mixing of salad

        return new Salad(ingredientPieces, saladDressing);
    }
}
