package ua.training.publishing;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> The LocalNewsAgency class.
 * This class describes some local news agency.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
public class LocalNewsAgency implements Publisher {

    /**
     * List of agency subscribers
     */
    private List<Subscriber> subscribers = new ArrayList<>();

    /**
     * Current subscription
     */
    private Subscription subscription;

    /**
     * Destination area
     */
    private Area area;

    /**
     * This method sends newspapers to the subscribers of specific area
     *
     * @param newspaper - some kind of news paper
     * @param area - destination area
     */
    public void sendNewspaper(LocalNewspaper newspaper, Area area) {
        subscription = newspaper;
        this.area = area;
        sendSubscriptions();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void sendSubscriptions() {
        if (area == null) {
            subscribers.stream()
                    .forEach(x -> x.takeSubscription(subscription));
        } else {
            subscribers.stream()
                    .filter(x -> x.getLocation() == area)
                    .forEach(x -> x.takeSubscription(subscription));
        }

    }
}
