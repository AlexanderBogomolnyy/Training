package ua.training.publishing;

/**
 * <p> The Subscriber interface.
 * This interface provides methods for getting subscription by the location
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
public interface Subscriber {

    /**
     * This method gets subscriber location
     *
     * @return - subscriber location
     */
    Area getLocation();

    /**
     * This method provides subscriber by subscription
     *
     * @param subscription - some kind of subscription
     */
    void takeSubscription(Subscription subscription);
}
