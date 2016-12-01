package ua.training.patterns.strategy;

/**
 * <p> The Strategy pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 01.12.2016.
 */
public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient client = new StrategyClient();

        int[] array0 = {1, 3, 2, 1};
        client.setStrategy(new SelectedSort());
        client.executeStrategy(array0);

        int[] array1 = {11, 4, 2, 7, 8, 54};
        client.setStrategy(new InsertingSort());
        client.executeStrategy(array1);

        int[] array2 = {3, -8, 2, 0, 33, 1, 3, 2};
        client.setStrategy(new BubbleSort());
        client.executeStrategy(array2);

    }
}
