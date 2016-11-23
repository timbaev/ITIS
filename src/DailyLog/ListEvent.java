package DailyLog;

import java.util.ArrayList;

public class ListEvent {
    ArrayList<Event> eventArray = new ArrayList<Event>();
    boolean successful;

    public boolean add(Event event) {
        String eventStr = event.getEvent();
        successful = false;
        if (eventStr != null) {
            eventArray.add(event);
            successful = true;
        }
        return successful;
    }

    public ArrayList getArray() {
        return eventArray;
    }
}