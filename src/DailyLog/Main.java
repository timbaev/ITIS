package DailyLog;

import DailyLog.CSVUtils;
import DailyLog.Event;
import DailyLog.ListEvent;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

//TODO сделать красивый код + инкапсуляция
public class Main {

    static ListEvent listEvent = new ListEvent();
    static FileWriter writer;
    static String csvFile = "database.csv";

    public static void main(String[] args) {

        String event;
        String date;
        String dateStart;
        String dateEnd;
        boolean isAddEvent;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Error writing file");
        System.out.println("Welcome! It is a try IT daily log!");
        printDocumentation();
        System.out.print("Enter the command: ");
        String input;
        while(scanner.hasNextLine()) {
            input = scanner.nextLine();
            //comment
            switch(input) {
                case "exit":
                    try {
                        System.out.println("Closing the program");
                        System.exit(0);
                    } catch (Exception e) {
                        System.out.println("Oups..error..");
                    }
                    break;
                case "add event for day":
                    System.out.print("Enter event: ");
                    event = scanner.nextLine();
                    System.out.print("Enter date (dd.MM.yy): ");
                    date = scanner.nextLine();
                    isAddEvent = listEvent.add(new Event(event, date));
                    if (isAddEvent) {
                        recordToDatabase(event, date);
                        System.out.println("Done!");
                    }
                    System.out.print("Enter the command: ");
                    break;
                case "add event for period":
                    System.out.print("Enter event: ");
                    event = scanner.nextLine();
                    System.out.print("Enter start date (dd.MM.yy): ");
                    dateStart = scanner.nextLine();
                    System.out.print("Enter end date (dd.MM.yy): ");
                    dateEnd = scanner.nextLine();
                    isAddEvent = listEvent.add(new Event(event, dateStart, dateEnd));
                    if (isAddEvent) {
                        recordToDatabase(event, dateStart + " - " + dateEnd);
                        System.out.println("Done!");
                    }
                    System.out.print("Enter the command: ");
                    break;
                case "print all TODO list":
                    //printList(listEvent.getArray());
                    getEvents();
                    System.out.print("Enter the command: ");
                    break;
                case "print TODO list for date":
                    System.out.print("Enter date (dd.MM.yy): ");
                    date = scanner.nextLine();
                    //findDate(date, listEvent.getArray());
                    getEventsForDay(date);
                    System.out.print("Enter the command: ");
                    break;
                case "print TODO list for period": //TODO сделать вывод на период
                    System.out.print("Enter period: ");
                    System.out.print("Enter start date (dd.MM.yy): ");
                    dateStart = scanner.nextLine();
                    System.out.print("Enter end date (dd.MM.yy): ");
                    dateEnd = scanner.nextLine();
                    findPeriodDate(dateStart, dateEnd, listEvent.getArray());
                    System.out.print("Enter the command: ");
                    break;
                case "check day":
                    System.out.print("Enter date (dd.MM.yy): ");
                    date = scanner.nextLine();
                    if (checkDay(date, listEvent.getArray())) {
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

    public static void printList(ArrayList list) {
        int size = list.size();
        System.out.println("You all TODO list: ");
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i).toString());
            System.out.println("____________________");
        }
    }

    public static void findDate(String date, ArrayList list) {
        int size = list.size();
        Calendar calendar = createCalendar(date); //what is it???
        System.out.println("You TODO list for: " + date);
        for (int i = 0; i < size; i++) {
            Event event = (Event) list.get(i);
            if (event.getIsPeriod()) {
                Calendar calStart = event.getDateStart();
                Calendar calEnd = event.getDateEnd();
                if (calStart.compareTo(calendar) == 0 || calEnd.compareTo(calendar) == 0
                        || (calStart.before(calendar) && calEnd.after(calendar))) {
                    System.out.println(event.toString());
                    System.out.println("____________________");
                }
            } else {
                Calendar calEvent = event.getDate();
                if (calEvent.compareTo(calendar) == 0) {
                    System.out.println(event.toString());
                    System.out.println("____________________");
                }
            }
        }
    }

    public static void findPeriodDate(String dateStart, String dateEnd, ArrayList list) {
        try{
            int size = list.size();
            Calendar calStart = createCalendar(dateStart);
            Calendar calEnd = createCalendar(dateEnd);
            if (calStart.after(calEnd)) {
                throw new ParseException("incorrect dates", 0);
            }
            System.out.println("You TODO list from " + dateStart + " to " + dateEnd);
            for (int i = 0; i < size; i++) {
                Event event = (Event) list.get(i);
                if (event.getIsPeriod()) {
                    Calendar calEventStart = event.getDateStart();
                    Calendar calEventEnd = event.getDateEnd();
                    if ((calEventStart.equals(calStart) && calEventEnd.before(calEnd))
                            || (calEventStart.after(calStart) && calEventEnd.equals(calEnd))
                            || (calEventStart.after(calStart) && calEventEnd.before(calEnd))
                            || (calEventStart.equals(calStart) && calEventEnd.equals(calEnd))) {
                        System.out.println(event.toString());
                        System.out.println("____________________");
                    }
                } else {
                    Calendar calEvent = event.getDate();
                    if ((calEvent.after(calStart) && calEvent.before(calEnd)) || (calEvent.equals(calStart))
                            || (calEvent.equals(calEnd))) {
                        System.out.println(event.toString());
                        System.out.println("____________________");
                    }
                }
            }
        } catch (ParseException e) {
            System.out.println("You date is not correct, please, try again!");
        }
    }

    public static boolean checkDay(String date, ArrayList list) {
        boolean check = false;
        Calendar calendar = createCalendar(date);
        for (int i = 0; i < list.size(); i++) {
            Event event = (Event) list.get(i);
            if (event.getIsPeriod()) {
                Calendar calStart = event.getDateStart();
                Calendar calEnd = event.getDateEnd();
                if (calStart.compareTo(calendar) == 0 || calEnd.compareTo(calendar) == 0
                        || (calStart.before(calendar) && calEnd.after(calendar))) {
                    check = true;
                }
            } else {
                Calendar calEvent = event.getDate();
                if (calEvent.compareTo(calendar) == 0) {
                    check = true;
                }
            }
        }
        return check;
    }

    public static Calendar createCalendar(String date) {
        Calendar calendar = Calendar.getInstance();
        try{
            calendar.setLenient(false);
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
            sdf.setLenient(false);
            calendar.setTime(sdf.parse(date));
        } catch (ParseException e) {
            System.out.println("You date is not correct, please, try again!");
        }
        return calendar;
    }

    public static void printDocumentation() {
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

    public static void recordToDatabase(String event, String date) {
        try {
            writer = new FileWriter(csvFile, true);
            checkFile();
            List<String> list = new ArrayList<>();
            list.add(event);
            list.add(date);

            CSVUtils.writeLine(writer, list);

            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("Error created");
        }
    }

    public static void getEvents() {
        try {
            BufferedReader fp = new BufferedReader(new FileReader(csvFile));

            printHeader();

            String[] cols;
            while(fp.ready()) {
                cols = fp.readLine().split(",");
                System.out.format("%-30s%30s", cols[0], cols[1]);
                System.out.println();
                cols = null;
            }
            fp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkFile() {
        try {
            File file = new File(csvFile);
            if (file.length() == 0) {
                CSVUtils.writeLine(writer, Arrays.asList("DailyLog.Event", "Date"));
            }
        } catch (IOException e) {
            System.out.println("Error..can not write to file");
        }
    }

    public static void getEventsForDay(String date) {
        try {
            Calendar cal = createCalendar(date);
            BufferedReader bf = new BufferedReader(new FileReader(csvFile));
            printHeader();
            String[] cols;

            while(bf.ready()) {
                cols = bf.readLine().split(",");
                if (cols[1].length() == 8) { //работаем с датой без периода
                    Calendar dateCal = createCalendar(cols[1]);
                    if (cal.equals(dateCal)) {
                        System.out.format("%-30s%30s", cols[0], cols[1]);
                        System.out.println();
                    }
                } else if (cols[1].length() != 8) { //работаем с датой с периодом
                    String dateStart = cols[1].substring(0, 8);
                    String dateEnd = cols[1].substring(11);
                    Calendar dateStartCal = createCalendar(dateStart);
                    Calendar dateEndCal = createCalendar(dateEnd);
                    if (dateStartCal.compareTo(cal) == 0 || dateEndCal.compareTo(cal) == 0
                            || (dateStartCal.before(cal) && dateEndCal.after(cal))) {
                        System.out.format("%-30s%30s", cols[0], cols[1]);
                        System.out.println();
                    }
                }
            }
            bf.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error..file not found");
        } catch (IOException e) {
            System.out.println("Error..can not read a file");
        }
    }

    public static void getEventsForPeriod(String dateStart, String dateEnd) { //TODO пилить тут
        Calendar dateStartCal = createCalendar(dateStart);
    }

    public static void printHeader() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(csvFile));

            String[] hdr = bf.readLine().split(",");
            if (hdr != null) {
                System.out.format("%-30s%30s", hdr[0], hdr[1]);
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error..file not found");
        } catch (IOException e) {
            System.out.println("Error..can not read a file");
        }
    }
}