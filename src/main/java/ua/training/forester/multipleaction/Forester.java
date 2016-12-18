package ua.training.forester.multipleaction;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> The Forester class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 17.12.2016.
 */
public class Forester {

    /**
     * List of forester activities
     */
    private List<Activity> activities = new ArrayList<>();

    /**
     * This method adds some activity to forester list of possible activities
     *
     * @param activity - some kind of activity
     */
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * This method removes activity from the list of forester activities
     *
     * @param activity
     */
    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * This method force forester to act
     */
    public void act(Event event) {
        if (event != null)
            activities.stream().filter(act -> act.getEvent() == event).forEach(Activity::doAction);
        else
            System.out.println("I am not ready for such turn of events.");
    }
}
