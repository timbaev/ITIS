import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {

    private static FileWriter writer;
    private static String csvFile = "database.csv";
    private static boolean error;

    public static void main(String[] args) {

        String event;
        String date;
        String dateStart;
        String dateEnd = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Error writing file");
        System.out.println("Welcome! It is a try IT daily log!");
        printDocumentation();
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
                    System.out.print("Enter date (dd.MM.yy): ");
                    date = scanner.nextLine();
                    recordToDatabase(event, date);
                    System.out.print("Enter the command: ");
                    break;
                case "add event for period":
                    System.out.print("Enter event: ");
                    event = scanner.nextLine();
                    System.out.print("Enter start date (dd.MM.yy): ");
                    dateStart = scanner.nextLine();
                    createCalendar(dateStart);
                    if (!error) {
                        System.out.print("Enter end date (dd.MM.yy): ");
                        dateEnd = scanner.nextLine();
                        createCalendar(dateEnd);
                    }
                    if (!error) {
                        recordToDatabase(event, dateStart + " - " + dateEnd);
                    }
                    System.out.print("Enter the command: ");
                    break;
                case "print all TODO list":
                    getEvents();
                    System.out.print("Enter the command: ");
                    break;
                case "print TODO list for date":
                    System.out.print("Enter date (dd.MM.yy): ");
                    date = scanner.nextLine();
                    getEventsForDay(date, false);
                    System.out.print("Enter the command: ");
                    break;
                case "print TODO list for period":
                    System.out.println("Enter period: ");
                    System.out.print("Enter start date (dd.MM.yy): ");
                    dateStart = scanner.nextLine();
                    System.out.print("Enter end date (dd.MM.yy): ");
                    dateEnd = scanner.nextLine();
                    getEventsForPeriod(dateStart, dateEnd);
                    System.out.print("Enter the command: ");
                    break;
                case "check day":
                    System.out.print("Enter date (dd.MM.yy): ");
                    date = scanner.nextLine();
                    if (getEventsForDay(date, true)) {
                        System.out.println("This day is busy");
                    } else {
                        System.out.println("This day is free");
                    }
                    System.out.print("Enter the command: ");
                    break;
                case "documentation":
                    printDocumentation();
                    System.out.print("Enter the command: ");
                    break;
                default:
                    System.out.println("command not found, please check documentation");
                    System.out.print("Enter the command: ");
                    break;
            }
        }
    }

    private static Calendar createCalendar(String date) {
        Calendar calendar = Calendar.getInstance();
        error = false;
        try {
            calendar.setLenient(false);
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
            sdf.setLenient(false);
            calendar.setTime(sdf.parse(date));
        } catch (ParseException e) {
            System.out.println("You date is not correct, please, try again!");
            error = true;
        }
        return calendar;
    }

    private static void printDocumentation() {
        System.out.println("Documentation");
        System.out.println("In this program, you can:");
        System.out.println("1) add event for day");
        System.out.println("2) add event for period");
        System.out.println("3) check day");
        System.out.println("4) print all TODO list");
        System.out.println("5) print TODO list for date");
        System.out.println("6) print TODO list for period");
        System.out.println("7) documentation");
        System.out.println("8) exit");
        System.out.println("____________________");
    }

    private static void recordToDatabase(String event, String date) {
        try {
            writer = new FileWriter(csvFile, true);
            checkFile();
            createCalendar(date);
            if (!error) {
                List<String> list = new ArrayList<>();
                list.add(event);
                list.add(date);

                CSVUtils.writeLine(writer, list);

                writer.flush();
                writer.close();
                System.out.println("Done!");
            }
        } catch (Exception e) {
            System.out.println("Error created");
        }
    }

    private static void getEvents() {
        try {
            BufferedReader fp = new BufferedReader(new FileReader(csvFile));

            printHeader(fp);

            String[] cols;
            while (fp.ready()) {
                cols = fp.readLine().split(",");
                System.out.format("%-30s%30s", cols[0], cols[1]);
                System.out.println();
            }
            fp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkFile() {
        try {
            File file = new File(csvFile);
            if (file.length() == 0) {
                CSVUtils.writeLine(writer, Arrays.asList("Event", "Date"));
            }
        } catch (IOException e) {
            System.out.println("Error..can not write to file");
        }
    }

    private static boolean getEventsForDay(String date, boolean isCheck) {
        boolean check = false;
        try {
            Calendar cal = createCalendar(date);
            BufferedReader bf = new BufferedReader(new FileReader(csvFile));
            if (!isCheck) {
                printHeader(bf);
            } else {
                bf.readLine();
            }
            String[] cols;
            while (bf.ready()) {
                cols = bf.readLine().split(",");
                if (cols[1].length() == 8) { //работаем с датой без периода
                    Calendar dateCal = createCalendar(cols[1]);
                    if (cal.equals(dateCal)) {
                        if (!isCheck) {
                            System.out.format("%-30s%30s", cols[0], cols[1]);
                            System.out.println();
                        } else {
                            check = true;
                        }
                    }
                } else if (cols[1].length() != 8) { //работаем с датой с периодом
                    String dateStart = cols[1].substring(0, 8);
                    String dateEnd = cols[1].substring(11);
                    Calendar dateStartCal = createCalendar(dateStart);
                    Calendar dateEndCal = createCalendar(dateEnd);
                    if (dateStartCal.compareTo(cal) == 0 || dateEndCal.compareTo(cal) == 0
                            || (dateStartCal.before(cal) && dateEndCal.after(cal))) {
                        if (!isCheck) {
                            System.out.format("%-30s%30s", cols[0], cols[1]);
                            System.out.println();
                        } else {
                            check = true;
                        }
                    }
                }
            }
            bf.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error..file not found");
        } catch (IOException e) {
            System.out.println("Error..can not read a file");
        }
        return check;
    }

    private static void getEventsForPeriod(String dateStart, String dateEnd) {
        Calendar dateStartCal = createCalendar(dateStart);
        Calendar dateEndCal = createCalendar(dateEnd);

        try {
            BufferedReader bf = new BufferedReader(new FileReader(csvFile));
            printHeader(bf);
            String cols[];

            while (bf.ready()) {
                cols = bf.readLine().split(",");
                if (cols[1].length() == 8) {
                    Calendar dateCal = createCalendar(cols[1]);
                    if ((dateCal.after(dateStartCal) && dateCal.before(dateEndCal)) || (dateCal.equals(dateStartCal))
                            || (dateCal.equals(dateEndCal))) {
                        System.out.format("%-30s%30s", cols[0], cols[1]);
                        System.out.println();
                    }
                } else if (cols[1].length() != 8) {
                    String dateStartStr = cols[1].substring(0, 8);
                    String dateEndStr = cols[1].substring(11);
                    Calendar dateStartStrCal = createCalendar(dateStartStr);
                    Calendar dateEndStrCal = createCalendar(dateEndStr);
                    if ((dateStartStrCal.equals(dateStartCal) && dateEndStrCal.before(dateEndCal))
                            || (dateStartStrCal.after(dateStartCal) && dateEndStrCal.equals(dateEndCal))
                            || (dateStartStrCal.after(dateStartCal) && dateEndStrCal.before(dateEndCal))
                            || (dateStartStrCal.equals(dateStartCal) && dateEndStrCal.equals(dateEndCal))) {
                        System.out.format("%-30s%30s", cols[0], cols[1]);
                        System.out.println();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error..file not found");
        } catch (IOException e) {
            System.out.println("Error..can not read file");
        }
    }

    private static void printHeader(BufferedReader bf) {
        try {
            String[] hdr = bf.readLine().split(",");
            System.out.format("%-30s%30s", hdr[0], hdr[1]);
            System.out.println();

        } catch (FileNotFoundException e) {
            System.out.println("Error..file not found");
        } catch (IOException e) {
            System.out.println("Error..can not read a file");
        }
    }
}