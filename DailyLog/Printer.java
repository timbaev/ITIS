import java.util.ArrayList;

/**
 * Created by Timbaev on 21.12.2016.
 * Printer information. Helps to create the table and to place there data.
 */
public class Printer {

    public static void printDocumentation() {
        System.out.println("Documentation");
        System.out.println("In this program, you can:");
        System.out.println("1) add event for day");
        System.out.println("2) add event for period");
        System.out.println("3) clear events");
        System.out.println("4) check date");
        System.out.println("5) print all TODO list");
        System.out.println("6) print current TODO list");
        System.out.println("7) print TODO list for date");
        System.out.println("8) print TODO list for period");
        System.out.println("9) find event");
        System.out.println("10) documentation");
        System.out.println("11) exit");
        System.out.println("____________________");
    }

    public static void createASCIITable(ArrayList<Event> events) {
        if (events.size() != 0) {
            String leftAlignFormat = "| %-30s | %-35s |%n";

            System.out.format("+--------------------------------+-------------------------------------+%n");
            System.out.format("|            Event               |                 Date                |%n");
            System.out.format("+--------------------------------+-------------------------------------+%n");
            for (Event event : events) {
                System.out.format(leftAlignFormat, event.getName(), event.getDate());
            }
            System.out.format("+--------------------------------+-------------------------------------+%n");
        } else {
            System.out.println("You have zero events");
        }
    }
}
