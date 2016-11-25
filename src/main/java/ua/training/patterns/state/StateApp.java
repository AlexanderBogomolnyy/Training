package ua.training.patterns.state;

/**
 * <p> The State pattern sample.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 25.11.2016.
 */
public class StateApp {
    public static void main(String[] args) {
        System.out.println(" ---== Radio Station ==---");
        Station radioRoks = new RadioRoks();
        Radio radio = new Radio();
        radio.setStation(radioRoks);

        for(int i = 0; i < 10; i++) {
            radio.play();
            radio.nextStation();
        }

        System.out.println("\n ---== Human Activity ==---");
        Human human = new Human();
        human.setState(new Work());

        for(int i = 0; i < 10; i++) {
            human.doSomething();
        }
    }
}
