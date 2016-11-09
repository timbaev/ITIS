import java.util.Scanner;
import java.util.Calendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {
	
	public static void main(String[] args) {
		String event;
		String date;
		String dateStart;
		String dateEnd;
		boolean isAddEvent;
		ListEvent listEvent = new ListEvent();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome! It is a try IT daily log!");
		printDocumentation();
		System.out.print("Enter the command: ");
		String input;
		while(scanner.hasNextLine()) {
			input = scanner.nextLine();
			switch(input) {
				case "exit": 
					System.out.println("Closing the program");
					System.exit(0);
					break;
				case "add event for day":
					System.out.print("Enter event: ");
					event = scanner.nextLine();
					System.out.print("Enter date (dd.MM.yy): ");
					date = scanner.nextLine();
					isAddEvent = listEvent.add(new Event(event, date));
					if (isAddEvent) {
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
						System.out.println("Done!");
					}
					System.out.print("Enter the command: ");
					break;
				case "print all TODO list": 
					printList(listEvent.getArray());
					System.out.print("Enter the command: ");
					break;
				case "print TODO list for date": 
					System.out.print("Enter date (dd.MM.yy): ");
					date = scanner.nextLine();
					findDate(date, listEvent.getArray());
					System.out.print("Enter the command: ");
					break;
				case "print TODO list for period":
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
		Calendar calendar = createCalendar(date);
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
}