package ua.training.salad;

import ua.training.salad.ingredient.IngredientPiece;
import ua.training.salad.saladdressing.SaladDressing;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> The Salad class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 18.12.2016.
 */
public class Salad {

    /**
     * The list of ingredient pieces
     */
    private List<IngredientPiece> pieces = new ArrayList<>();

    /**
     * The salad dressing
     */
    private SaladDressing saladDressing;

    public Salad(List<IngredientPiece> pieces, SaladDressing saladDressing) {
        this.pieces = pieces;
        this.saladDressing = saladDressing;
    }

    /**
     * This method views the salad
     */
    public void viewSalad() {
        System.out.print("Salad: ");
        pieces.stream().map(x -> x.getType().name() + ", ").forEach(System.out::print);
        System.out.println(saladDressing.getSaladDressingType().name() + " as a salad dressing. ");
    }
}
