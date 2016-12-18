package ua.training.forester.singleaction;

/**
 * <p> The Forester class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public class Forester {

    /**
     * The forester activity
     */
    private Activity activity;

    /**
     * This method sets forester activity by the jaunt event
     *
     * @param event - jaunt event
     */
    public void setEvent(Event event) {
        System.out.print(event.getDescription() + " ");
        switch (event) {
            case ON_THE_RIVER_BANK:
                activity = new Fisher();
                break;
            case ON_THE_FOREST_GLADE:
                activity = new Mushroomer();
                break;
            case SEE_AN_ANIMAL:
                activity = new Hunter();
                break;
            default:
                throw new IllegalArgumentException("Wrong kind of event.");
        }
    }

    /**
     * This method for forester acting
     */
    public void act() {
        if (activity == null) {
            System.out.println("I am so lazy. I cannot do anything.");
        } else {
            activity.doAction(this);
        }
    }
}
