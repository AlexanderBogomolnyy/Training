package ua.training.publishing;

/**
 * <p> The LocalSubscriber class.
 * This class describes some local subscriber
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
public class LocalSubscriber implements Subscriber {

    /**
     * Subscriber location
     */
    private Area area;

    public LocalSubscriber(Area area) {
        this.area = area;
    }

    @Override
    public Area getLocation() {
        return area;
    }

    @Override
    public void takeSubscription(Subscription subscription) {
        System.out.print("Fresh newspaper received: ");
        System.out.println("\"" + subscription.getContent() + "\"");
    }

}
