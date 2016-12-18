package ua.training.forester.singleaction;

/**
 * <p> The enum of events.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public enum Event {
    ON_THE_RIVER_BANK ("I am on the river bank."),
    ON_THE_FOREST_GLADE ("I am on the forest glade."),
    SEE_AN_ANIMAL("I see an animal.");

    private String description;
    private Event(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
