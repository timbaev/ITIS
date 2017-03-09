package HW_7march.entitys;

import java.time.LocalTime;

/**
 * Created by Timbaev on 08.03.2017.
 * Track
 */
public class Track {

    private String name;
    private LocalTime duration;
    private Composer composer;
    private String genre;

    public Track(String name, LocalTime duration, Composer composer, String genre) {
        this.name = name;
        this.duration = duration;
        this.composer = composer;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public Composer getComposer() {
        return composer;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return name + " - " + composer.getName() + " (" + duration.toString() + ") " + "<" + genre + ">";
    }
}
