package ua.training.pizza;

/**
 * <p> The enum of pizza ingredients.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 19.12.2016.
 */
public enum Ingredient {
    GOUDA(Category.CHEESE),
    TOMATO(Category.VEGETABLE),
    CHICKEN(Category.MEET),
    SAUSAGES(Category.MEET),
    CORN(Category.VEGETABLE),
    CHAMPIGNON(Category.MUSHROOM),
    ONION(Category.VEGETABLE),
    STANDARD_BASE(Category.BASE);

    private Category category;

    private Ingredient(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
