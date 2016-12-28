/**
 * Created by Timbaev on 26.12.2016.
 * Support entity, which help to store names and dates for events.
 */
public class Event {

    private String name;
    private String date;

    public Event(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
