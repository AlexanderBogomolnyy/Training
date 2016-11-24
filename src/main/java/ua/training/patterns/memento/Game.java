package ua.training.patterns.memento;

/**
 * <p> This class represents some kind of game.
 * This class imitates Originator class of Memento pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
class Game {
    // current state of the game
    private String level;
    private int ms;

    public void set(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    /**
     * This method represents createMemento() method of Memento pattern idiom
     */
    public Save save() {
        return new Save(level, ms);
    }

    /**
     * This method represents setMemento(Memento m) method of Memento pattern idiom
     */
    public void load(Save save) {
        this.level = save.getLevel();
        this.ms = save.getMs();
    }

    @Override
    public String toString() {
        return "Game{" +
                "level='" + level + '\'' +
                ", ms=" + ms +
                '}';
    }
}
