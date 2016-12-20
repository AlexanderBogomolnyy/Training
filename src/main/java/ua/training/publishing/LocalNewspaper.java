package ua.training.publishing;

/**
 * <p> The LocalNewspaper class.
 * This class describes some local newspaper.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 20.12.2016.
 */
public class LocalNewspaper implements Subscription {

    /**
     * A constant holding newspaper title
     */
    public static final String TITLE = "LOCAL NEWS";

    /**
     * Newspaper content
     */
    private String news;

    public LocalNewspaper(String newsText) {
        this.news = TITLE + ": ";
        this.news = this.news + newsText;
    }

    @Override
    public String getContent() {
        return news;
    }
}
