package HW_14febrary.entities;

/**
 * Created by Timbaev on 14.02.2017.
 *
 */
public class Track {

    private String name;
    private String format;

    public Track(String name, String format) {
        this.name = name;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

}
