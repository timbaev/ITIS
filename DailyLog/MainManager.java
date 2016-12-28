package DailyLog;

import java.text.ParseException;
import java.util.*;

/**
 * The main class, which control work with user. Reads commands and executes them.
 *
 * @author Timur Shafigulin
 * @version 2.1
 * @since 03-11-2016
 */
public class MainManager {

    /**
     * The main method from which our daily log begins to work
     *
     * @param args it isn't used, because we are true IT and we use the scanner
     */
    public static void main(String[] args) {

        String event;
        String date;
        String dateStart;
        String dateEnd;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! It is a try IT daily log!");
        Printer.printDocumentation();
        System.out.print("Enter the command: ");
        String input;
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            switch (input) {
                case "exit":
                    System.out.println("Closing the program");
                    System.exit(0);
                    break;
                case "add event for day":
                    System.out.print("Enter event: ");
                    event = scanner.nextLine();
                    System.out.print("Enter date (dd.MM.yyyy HH:mm): ");
                    date = scanner.nextLine();
                    DatabaseManager.recordToDatabase(event, date);
                    System.out.print("Enter the command: ");
                    break;
                case "add event for period":
                    System.out.print("Enter event: ");
                    event = scanner.nextLine();
                    System.out.print("Enter date start (dd.MM.yyyy HH:mm): ");
                    dateStart = scanner.nextLine();
                    System.out.print("Enter date end (dd.MM.yyyy HH:mm): ");
                    dateEnd = scanner.nextLine();
                    DatabaseManager.recordToDatabase(event, dateStart, dateEnd);
                    System.out.print("Enter the command: ");
                    break;
                case "print all TODO list":
                    DatabaseManager.getAllEvents();
                    System.out.print("Enter the command: ");
                    break;
                case "print current TODO list":
                    DatabaseManager.checkBusyDay(Calendar.getInstance(), true);
                    System.out.print("Enter the command: ");
                    break;
                case "print TODO list for date":
                    System.out.print("Enter date (dd.MM.yyyy): ");
                    date = scanner.nextLine();
                    DatabaseManager.getEventsForDay(date);
                    System.out.print("Enter the command: ");
                    break;
                case "print TODO list for period":
                    System.out.println("Enter period: ");
                    System.out.print("Enter date start (dd.MM.yyyy HH:mm): ");
                    dateStart = scanner.nextLine();
                    System.out.print("Enter date end (dd.MM.yyyy HH:mm): ");
                    dateEnd = scanner.nextLine();
                    DatabaseManager.getEventsForPeriod(dateStart, dateEnd);
                    System.out.print("Enter the command: ");
                    break;
                case "check date":
                    System.out.print("Enter date (dd.MM.yyyy HH:mm): ");
                    date = scanner.nextLine();
                    try {
                        if (DatabaseManager.checkBusyDay(
                                CalendarCreater.createCalendar(date, CalendarCreater.FORMAT_WITH_HOURS, false), false)) {
                            System.out.println("This day is busy");
                        } else {
                            System.out.println("This day is free");
                        }
                    } catch (ParseException e) {
                        if (e.getErrorOffset() == -1) {
                            System.out.println(e.getMessage());
                        } else {
                            System.out.println("You date is not correct, please, try again!");
                        }
                    }
                    System.out.print("Enter the command: ");
                    break;
                case "clear events":
                    if (DatabaseManager.clearEvents()) {
                        System.out.println("Done!");
                    } else {
                        System.out.println("Error..can not clear events..call to support");
                    }
                    System.out.print("Enter the command: ");
                    break;
                case "find event":
                    System.out.print("Enter key word for search: ");
                    String keyWord = scanner.nextLine();
                    DatabaseManager.findEvents(keyWord);
                    System.out.print("Enter the command: ");
                    break;
                case "documentation":
                    Printer.printDocumentation();
                    System.out.print("Enter the command: ");
                    break;
                default:
                    System.out.println("command not found, please check documentation");
                    System.out.print("Enter the command: ");
                    break;
            }
        }
    }
}