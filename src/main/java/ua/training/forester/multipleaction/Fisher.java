package ua.training.forester.multipleaction;

/**
 * <p> The Forester activity class.
 * This class force Forester to become a Fisher
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public class Fisher implements Activity {
    @Override
    public Event getEvent() {
        return Event.RIVER_BANK;
    }

    @Override
    public void doAction() {
        System.out.print("Let's take a fish!!!!!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fisher)) return false;
        Fisher hunter = (Fisher) o;
        return hunter.getEvent() == this.getEvent();
    }

}
