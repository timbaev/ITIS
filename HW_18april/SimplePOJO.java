package HW_18april;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Timbaev on 18.04.2017.
 */
public class SimplePOJO implements Serializable {

    private String title;
    private Date date;
    private int count;

    public SimplePOJO(String title, Date date, int count) {
        this.title = title;
        this.date = date;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n"
                + "Date: " + date + "\n"
                + "count: " + count;
    }
}
