package ua.training.publishing;

/**
 * <p> The Publisher interface.
 * This interface provides methods for sending subscription to the subscribers
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
public interface Publisher {

    /**
     * This method adds subscriber to the publisher list of subscribers
     *
     * @param subscriber - some kind of subscriber
     */
    void addSubscriber(Subscriber subscriber);

    /**
     * This method removes subscriber from the publisher list of subscribers
     *
     * @param subscriber - some kind of subscriber
     */
    void removeSubscriber(Subscriber subscriber);

    /**
     * This method sends subscriptions to the publisher subscribers
     */
    void sendSubscriptions();
}
