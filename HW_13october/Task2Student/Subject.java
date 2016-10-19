import java.util.*;

public class Subject {
	
	String subject;
	boolean isPassExam;
	
	Subject(String subject) {
		this.subject = subject;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public boolean getPassExam() {
		return isPassExam;
	}
	
	public boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}
	
}