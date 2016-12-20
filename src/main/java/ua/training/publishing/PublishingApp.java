package ua.training.publishing;

/**
 * <p> The Publishing application class.
 * This class provides main executive method for application.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
public class PublishingApp {

    public static void main(String[] args) {
        // Initializing newspaper
        LocalNewspaper newspaper = new LocalNewspaper("Many interesting things happened today.");

        // Initializing subscribers
        Subscriber subscriber1 = new LocalSubscriber(Area.VILLAGE);
        Subscriber subscriber2 = new LocalSubscriber(Area.CITY);
        Subscriber subscriber3 = new LocalSubscriber(Area.VILLAGE);
        Subscriber subscriber4 = new LocalSubscriber(Area.TOWN);
        Subscriber subscriber5 = new LocalSubscriber(Area.VILLAGE);

        //Initializing news agency, adding subscribers
        LocalNewsAgency newsAgency = new LocalNewsAgency();
        newsAgency.addSubscriber(subscriber1);
        newsAgency.addSubscriber(subscriber2);
        newsAgency.addSubscriber(subscriber3);
        newsAgency.addSubscriber(subscriber4);
        newsAgency.addSubscriber(subscriber5);

        //Sending newspapers to subscribers of specific area
        newsAgency.sendNewspaper(newspaper, Area.VILLAGE);
    }

}
