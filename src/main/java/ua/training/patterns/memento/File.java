package ua.training.patterns.memento;

/**
 * <p> This class imitates data retention mechanism.
 * This class imitates Caretaker class of Memento pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 22.11.2016.
 */
class File {
    private Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}
