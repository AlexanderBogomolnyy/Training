package ua.training.forester.singleaction;

/**
 * <p> The Jaunt in the forest class.
 * This class contains main executive method, and imitates some sequence of events,
 * which can happen during the jaunt in the forest.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public class JauntInTheForest {

    public static void main(String[] args) {
        Forester forester = new Forester();
        System.out.println("Let's go for a jaunt.");
        for (Event event : Event.values()) {
            forester.setEvent(event);
            forester.act();
        }
    }

}
