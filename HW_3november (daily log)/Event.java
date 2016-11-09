import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Event {
	
	private String event;
	private Calendar calendar;
	private Calendar calStart;
	private Calendar calEnd;
	private SimpleDateFormat sdf;
	boolean isPeriod;
	
	Event(String event, String date) {
		isPeriod = false;
		try {
			sdf = new SimpleDateFormat("dd.MM.yy");
			calendar = Calendar.getInstance();
			sdf.setLenient(false);
			calendar.setTime(sdf.parse(date));
			this.event = event;
		} catch (ParseException e) {
			System.out.println("You date is not correct. please, try again!");
		}
	}
	
	Event(String event, String dateStart, String dateEnd) {
		isPeriod = true;
		try{
			sdf = new SimpleDateFormat("dd.MM.yy");
			calStart = Calendar.getInstance();
			calEnd = Calendar.getInstance();
			sdf.setLenient(false);
			calStart.setTime(sdf.parse(dateStart));
			calEnd.setTime(sdf.parse(dateEnd));
			if (calStart.after(calEnd)) {
				throw new ParseException("incorrect dates", 0);
			}
			this.event = event;
		} catch (ParseException e) {
			System.out.println("You date is not correct. please, try again!");
		}
	}
	
	public String toString() {
		String result = "";
		if (isPeriod) {
			String dateStart = sdf.format(calStart.getTime());
			String dateEnd = sdf.format(calEnd.getTime());
			result = "Event: " + event + "\n" + "Date start: " + dateStart + "\n" + "Date end: " + dateEnd; 
		} else {
			String date = sdf.format(calendar.getTime());
			result = "Event: " + event + "\n" + "Date: " + date;
		}
		return result;
	}
	
	public Calendar getDate() {
		return calendar;
	}
	
	public Calendar getDateStart() {
		return calStart;
	}
	
	public Calendar getDateEnd() {
		return calEnd;
	}
	
	public String getEvent() {
		return event;
	}
	
	public boolean getIsPeriod() {
		return isPeriod;
	}
}