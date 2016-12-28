package DailyLog;

/**
 * Support entity, which help to store names and dates for events.
 *
 * @author Timur Shafigullin
 * @version 1.1
 * @since 26-12-2016
 */
public class Event {

    /**
     * Simple variables, to store name and date
     */
    private String name;
    private String date;

    /**
     * Constructor, which create new Event with name and date
     *
     * @param name name of event
     * @param date date of event
     */
    public Event(String name, String date) {
        this.name = name;
        this.date = date;
    }

    /**
     * Get name of event
     *
     * @return name of event
     */
    public String getName() {
        return name;
    }

    /**
     * Get date of event
     *
     * @return date of event
     */
    public String getDate() {
        return date;
    }
}
