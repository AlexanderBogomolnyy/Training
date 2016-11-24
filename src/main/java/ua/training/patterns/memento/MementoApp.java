package ua.training.patterns.memento;

/**
 * <p> The Memento pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 24.11.2016.
 */
public class MementoApp {
    public static void main(String[] args) {
        Game game = new Game();
        game.set("LVL_1", 30000);
        System.out.println(game);

        File file = new File();
        file.setSave(game.save());
        game.set("LVL_2", 55000);
        System.out.println(game);

        System.out.println("---== load game ==---");
        game.load(file.getSave());
        System.out.println(game);
    }
}
