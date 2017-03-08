package CW_28febrary.Comporator;

/**
 * Created by Timbaev on 28.02.2017.
 *
 */
public class Track implements Comparable<Track> {

    private String name;
    private int duration;
    private Composer composer;

    public Track(String name, int duration, Composer composer) {
        this.name = name;
        this.duration = duration;
        this.composer = composer;
    }

    @Override
    public int compareTo(Track o) {
        return name.compareTo(o.getName());
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public Composer getComposer() {
        return composer;
    }
}
