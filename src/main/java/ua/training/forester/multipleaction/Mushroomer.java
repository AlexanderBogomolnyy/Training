package ua.training.forester.multipleaction;

/**
 * <p> The Forester activity class.
 * This class force Forester to become a Mushroomer
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public class Mushroomer implements Activity {
    @Override
    public Event getEvent() {
        return Event.FOREST_GLADE;
    }

    @Override
    public void doAction() {
        System.out.print("Let's collect mushrooms!!!!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mushroomer)) return false;
        Mushroomer hunter = (Mushroomer) o;
        return hunter.getEvent() == this.getEvent();
    }

}
