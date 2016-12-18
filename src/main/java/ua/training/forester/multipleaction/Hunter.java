package ua.training.forester.multipleaction;

/**
 * <p> The Forester activity class.
 * This class force Forester to become a Hunter
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public class Hunter implements Activity {

    @Override
    public Event getEvent() {
        return Event.AN_ANIMAL;
    }

    @Override
    public void doAction() {
        System.out.print("Let's hunt!!!!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hunter)) return false;
        Hunter hunter = (Hunter) o;
        return hunter.getEvent() == this.getEvent();
    }

}
