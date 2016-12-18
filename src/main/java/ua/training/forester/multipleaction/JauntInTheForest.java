package ua.training.forester.multipleaction;

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
        forester.addActivity(new Hunter());
        System.out.println("Let's go for a jaunt.");
        System.out.println("----------------------------------");

        action(forester);

        forester.addActivity(new Fisher());

        action(forester);

        forester.addActivity(new Mushroomer());

        action(forester);

        forester.removeActivity(new Hunter());
        forester.removeActivity(new Fisher());

        action(forester);
    }

    // this method calls all possible events for forester
    private static void action(Forester forester) {
        for (Event event : Event.values()) {
            System.out.print(event.getAppearance() + " ");
            forester.act(event);
            System.out.println();
        }
        System.out.println("----------------------------------");
    }

}
