package DailyLog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class for help to create Calendar with check of a correctness
 * it help create Calendar very simple.
 *
 * @author Timur Shafigullin
 * @version 1.5
 * @since 21-12-2016
 */
public class CalendarCreater {

    /**
     * Constants, which helped create Calendar with hours or without
     */
    public final static String FORMAT_ONLY_DAY = "dd.MM.yyyy";
    public final static String FORMAT_WITH_HOURS = "dd.MM.yyyy HH:mm";

    /**
     * This method create new Calendar by date
     *
     * @param date           date with which it is necessary to create the Calendar
     * @param format         format which is used for check
     * @param setLenientPast whether to give an error message if date specifies the past
     * @return result of Calendar
     * @throws ParseException if date not correct, then is thrown out an exception
     */
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

    /**
     * This method set time in Calendar to zero
     *
     * @param date Calendar in which is necessary to nullify time
     * @return result Calendar with zero time
     */
    public static Calendar getZeroTimeDate(Calendar date) {
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        return date;
    }
}
