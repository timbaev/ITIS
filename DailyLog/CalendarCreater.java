import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Timbaev on 21.12.2016.
 * This class for help to create Calendar with check of a correctness
 * it help create Calendar very simple.
 */
public class CalendarCreater {

    public final static String FORMAT_ONLY_DAY = "dd.MM.yyyy";
    public final static String FORMAT_WITH_HOURS = "dd.MM.yyyy HH:mm";

    public static Calendar createCalendar(String date, String format, boolean setLenientPast) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        calendar.setTime(sdf.parse(date));

        if (!setLenientPast) {
            if (calendar.before(Calendar.getInstance())) {
                throw new ParseException("Error..you date in the past", -1);
            }
        }
        return calendar;
    }

    public static Calendar getZeroTimeDate(Calendar date) {
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        return date;
    }
}
