package ua.training.patterns.memento;

/**
 * <p> This class represents game save.
 * This class imitates Memento class of Memento pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
class Save {
    private final String level;
    private final int ms;

    public Save(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    public String getLevel() {
        return level;
    }

    public int getMs() {
        return ms;
    }
}
