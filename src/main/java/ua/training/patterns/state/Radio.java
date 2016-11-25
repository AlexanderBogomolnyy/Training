package ua.training.patterns.state;

/**
 * <p> The class imitates some kind of Radio receiver.
 * This is a Context class from State pattern idiom.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 25.11.2016.
 */
class Radio {
    private Station station;

    public void setStation(Station station) {
        this.station = station;
    }

    public void nextStation() {
        if (station instanceof RadioRoks) {
            setStation(new RadioHitFM());
        } else if (station instanceof RadioHitFM) {
            setStation(new RadioRelax());
        } else if (station instanceof RadioRelax) {
            setStation(new RadioRoks());
        }
    }

    public void play() {
        station.play();
    }
}
