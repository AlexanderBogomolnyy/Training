package ua.training.forester.multipleaction;

/**
 * <p> The enum of events.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public enum Event {
    RIVER_BANK ("I am on the river bank."),
    FOREST_GLADE ("I am on the forest glade."),
    AN_ANIMAL("I see an animal.");

    private String appearance;

    private Event(String appearance) {
        this.appearance = appearance;
    }

    public String getAppearance() {
        return appearance;
    }

}
