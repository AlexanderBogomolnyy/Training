package ua.training.patterns.prototype;

/**
 * <p> The Human Factory class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 22.11.2016.
 */
class HumanFactory {
    Human human;

    HumanFactory(Human human) {
        setPrototype(human);
    }

    void setPrototype(Human human) {
        this.human = human;
    }

    Human makeCopy() {
        return (Human) human.copy();
    }
}
