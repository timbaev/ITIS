package DailyLog;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Database Manager. Find and actions with events.
 * I think, the code can be simplified. But it is necessary to rewrite the main structure of a code.
 *
 * @author Timur Shafigullin
 * @version 1.2.1
 * @since 21-12-2016
 */
public class DatabaseManager {

    /**
     * static objects, which using in the class
     */
    private static FileWriter writer;
    private static String csvFile = "database.csv";
    private static ArrayList<Event> events = new ArrayList<>();

    /**
     * To write a new event with date in the file
     *
     * @param event name of event
     * @param date  date of event
     * @see DatabaseManager#recordToDatabase(String, String, String) also see for date with period
     */
    public static void recordToDatabase(String event, String date) {
        try {
            writer = new FileWriter(csvFile, true);

            Calendar dateCal = CalendarCreater.createCalendar(date, CalendarCreater.FORMAT_WITH_HOURS, false);
            if (!checkBusyDay(dateCal, false)) {
                List<String> list = new ArrayList<>();
                list.add(event);
                list.add(date);

                CSVUtils.writeLine(writer, list);

                writer.flush();
                writer.close();
                System.out.println("Done!");
            } else {
                System.out.println("Error..this day is busy");
            }
        } catch (ParseException e) {
            if (e.getErrorOffset() == -1) {
                System.out.println(e.getMessage());
            } else {
                System.out.println("You date is not correct, please, try again!");
            }
        } catch (IOException e) {
            System.out.println("Error..can not read a file");
        }
    }

    /**
     * To write a new event with period date in the file
     *
     * @param event     name of event
     * @param dateStart date of start of event
     * @param dateEnd   date of end of event
     * @see DatabaseManager#recordToDatabase(String, String) also see for date without period
     */
    public static void recordToDatabase(String event, String dateStart, String dateEnd) {
        try {
            writer = new FileWriter(csvFile, true);

            Calendar startCal = CalendarCreater.createCalendar(dateStart, CalendarCreater.FORMAT_WITH_HOURS, false);
            Calendar endCal = CalendarCreater.createCalendar(dateEnd, CalendarCreater.FORMAT_WITH_HOURS, false);
            if (!checkBusyDay(startCal, false) && !checkBusyDay(endCal, false)) {
                List<String> list = new ArrayList<>();
                list.add(event);
                list.add(dateStart + " - " + dateEnd);

                CSVUtils.writeLine(writer, list);

                writer.flush();
                writer.close();
                System.out.println("Done!");
            } else {
                System.out.println("Error..this day is busy");
            }
        } catch (ParseException e) {
            if (e.getErrorOffset() == -1) {
                System.out.println(e.getMessage());
            } else {
                System.out.println("You date is not correct, please, try again!");
            }
        } catch (IOException e) {
            System.out.println("Error..can not read a file");
        }
    }

    /**
     * This method get all data from a database and sends to the Printer on the printing
     */
    public static void getAllEvents() {
        try {
            BufferedReader fp = new BufferedReader(new FileReader(csvFile));

            events.clear();
            String[] cols;
            while (fp.ready()) {
                cols = fp.readLine().split(",");
                events.add(new Event(cols[0], cols[1]));
            }
            fp.close();
            Printer.createASCIITable(events);
        } catch (Exception e) {
            System.out.println("Error..you have zero events");
        }
    }

    /**
     * This method get data from a database for a certain date
     *
     * @param date certain date
     */
    public static void getEventsForDay(String date) {
        events.clear();
        try {
            Calendar dateCal = CalendarCreater.createCalendar(date, CalendarCreater.FORMAT_ONLY_DAY, true);
            CalendarCreater.getZeroTimeDate(dateCal);
            BufferedReader bf = new BufferedReader(new FileReader(csvFile));
            String[] cols;
            while (bf.ready()) {
                cols = bf.readLine().split(",");
                if (cols[1].length() == 16) { //работаем с датой без периода
                    Calendar dateFile = CalendarCreater.createCalendar(cols[1], CalendarCreater.FORMAT_WITH_HOURS, true);
                    CalendarCreater.getZeroTimeDate(dateFile);
                    if (dateFile.equals(dateCal)) {
                        events.add(new Event(cols[0], cols[1]));
                    }
                } else if (cols[1].length() != 16) { //работаем с датой с периодом
                    String dateStart = cols[1].substring(0, 16);
                    String dateEnd = cols[1].substring(19);
                    Calendar dateFileStart = CalendarCreater.createCalendar(dateStart, CalendarCreater.FORMAT_WITH_HOURS, true);
                    Calendar dateFileEnd = CalendarCreater.createCalendar(dateEnd, CalendarCreater.FORMAT_WITH_HOURS, true);
                    CalendarCreater.getZeroTimeDate(dateFileStart);
                    CalendarCreater.getZeroTimeDate(dateFileEnd);
                    if (dateFileStart.compareTo(dateCal) == 0 || dateFileEnd.compareTo(dateCal) == 0
                            || (dateFileStart.before(dateCal) && dateFileEnd.after(dateCal))) {
                        events.add(new Event(cols[0], cols[1]));
                    }
                }
            }
            bf.close();
            Printer.createASCIITable(events);

        } catch (FileNotFoundException e) {
            System.out.println("Error..you have zero events");
        } catch (IOException e) {
            System.out.println("Error..can not read a file");
        } catch (ParseException e) {
            if (e.getErrorOffset() == -1) {
                System.out.println(e.getMessage());
            } else {
                System.out.println("You date is not correct, please, try again!");
            }
        }
    }

    /**
     * This method checks for employment day
     *
     * @param day   day, which need for check
     * @param print function of the printing. If true, then busy days will in addition be printed.
     * @return the result, is occupied day or is free
     */
    public static boolean checkBusyDay(Calendar day, boolean print) {
        boolean check = false;
        events.clear();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(csvFile));
            String cols[];
            while (bf.ready()) {
                cols = bf.readLine().split(",");
                if (cols[1].length() == 16) { //работаем с датой без периода
                    Calendar dateFile = CalendarCreater.createCalendar(cols[1], CalendarCreater.FORMAT_WITH_HOURS, true);
                    dateFile.add(Calendar.HOUR, 1);
                    if (!dateFile.before((Calendar.getInstance()))) {
                        Calendar dateFileHour = dateFile;
                        dateFileHour.add(Calendar.HOUR, -1);
                        if (day.before(dateFile) && day.after(dateFileHour)) {
                            if (print) {
                                events.add(new Event(cols[0], cols[1]));
                            }
                            check = true;
                        }
                    }
                } else if (cols[1].length() != 16) { //работаем с датой с периодом
                    String dateStart = cols[1].substring(0, 16);
                    String dateEnd = cols[1].substring(19);
                    Calendar dateFileStart = CalendarCreater.createCalendar(dateStart, CalendarCreater.FORMAT_WITH_HOURS, true);
                    Calendar dateFileEnd = CalendarCreater.createCalendar(dateEnd, CalendarCreater.FORMAT_WITH_HOURS, true);
                    if (dateFileStart.compareTo(day) == 0 || dateFileEnd.compareTo(day) == 0
                            || (dateFileStart.before(day) && dateFileEnd.after(day))) {
                        if (print) {
                            events.add(new Event(cols[0], cols[1]));
                        }
                        check = true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error..can not read a file");
        } catch (ParseException e) {
            if (e.getErrorOffset() == -1) {
                System.out.println(e.getMessage());
            } else {
                System.out.println("You date is not correct, please, try again!");
            }
        }
        if (print) {
            Printer.createASCIITable(events);
        }
        return check;
    }

    /**
     * This method get data from a database for a certain period date and print it
     *
     * @param dateStart date with which to begin search
     * @param dateEnd   date with which to finish search
     */
    public static void getEventsForPeriod(String dateStart, String dateEnd) {
        events.clear();

        try {
            Calendar dateStartCal = CalendarCreater.createCalendar(dateStart, CalendarCreater.FORMAT_WITH_HOURS, true);
            Calendar dateEndCal = CalendarCreater.createCalendar(dateEnd, CalendarCreater.FORMAT_WITH_HOURS, true);

            BufferedReader bf = new BufferedReader(new FileReader(csvFile));
            String cols[];

            while (bf.ready()) {
                cols = bf.readLine().split(",");
                if (cols[1].length() == 16) {
                    Calendar dateCal = CalendarCreater.createCalendar(cols[1], CalendarCreater.FORMAT_WITH_HOURS, true);
                    if ((dateCal.after(dateStartCal) && dateCal.before(dateEndCal)) || (dateCal.equals(dateStartCal))
                            || (dateCal.equals(dateEndCal))) {
                        events.add(new Event(cols[0], cols[1]));
                    }
                } else if (cols[1].length() != 16) {
                    String dateStartStr = cols[1].substring(0, 16);
                    String dateEndStr = cols[1].substring(19);
                    Calendar dateFileStart = CalendarCreater.createCalendar(dateStartStr, CalendarCreater.FORMAT_WITH_HOURS, true);
                    Calendar dateFileEnd = CalendarCreater.createCalendar(dateEndStr, CalendarCreater.FORMAT_WITH_HOURS, true);
                    if ((dateFileStart.equals(dateStartCal) && dateFileEnd.before(dateEndCal))
                            || (dateFileStart.after(dateStartCal) && dateFileEnd.equals(dateEndCal))
                            || (dateFileStart.after(dateStartCal) && dateFileEnd.before(dateEndCal))
                            || (dateFileStart.equals(dateStartCal) && dateFileEnd.equals(dateEndCal))) {
                        events.add(new Event(cols[0], cols[1]));
                    }
                }
            }
            Printer.createASCIITable(events);
        } catch (FileNotFoundException e) {
            System.out.println("Error..you have zero events");
        } catch (IOException e) {
            System.out.println("Error..can not read file");
        } catch (ParseException e) {
            if (e.getErrorOffset() == -1) {
                System.out.println(e.getMessage());
            } else {
                System.out.println("You date is not correct, please, try again!");
            }
        }
    }

    /**
     * Delete all events
     *
     * @return result of deleting
     */
    public static boolean clearEvents() {
        File file = new File(csvFile);
        return file.delete();
    }

    /**
     * Helps to find an event according to the keyword
     *
     * @param keyword the keyword according to which we look for
     */
    public static void findEvents(String keyword) {
        events.clear();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(csvFile));
            String[] cols;
            while (bf.ready()) {
                cols = bf.readLine().split(",");
                if (cols[0].contains(keyword)) {
                    events.add(new Event(cols[0], cols[1]));
                }
            }
            Printer.createASCIITable(events);
        } catch (IOException e) {
            System.out.println("Error..can not read a file");
        }
    }
}
