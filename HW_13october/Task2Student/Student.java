import java.util.*;

public class Student {
	
	String name;
	String surname;
	int course;
	int age;
	int year;
	double GPA;
	int[] marks;
	
	
	Student(String name, String surname, int age, int year) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.year = year;
		marks = progress();
		GPA = calcGPA(marks);
	}

	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getCourse() {
		return getCourse(year);
	}
	
	public int[] getMarks() {
		return marks;
	}
	
	public double getGPA() {
		return GPA;
	} 
	
	
	//Узнаём текущий курс студента
	public int getCourse(int startStudyYear) {
		Calendar startYear = Calendar.getInstance();
		startYear.set(Calendar.YEAR, startStudyYear);
		long yearStudy = startYear.getTimeInMillis();
		long today = System.currentTimeMillis();
		long yearResult = today - year;
		startYear.setTimeInMillis(yearResult);
		int year = startYear.get(Calendar.YEAR) - 1970 + 1;
		return year;
	}
	
	//Узнаём успеваемость
	public int[] progress() {
		Random random = new Random();
		int[] marks = new int[10];
		double sum;
		int mark;
		
		for (int i = 0; i < 10; i++) {
			mark = random.nextInt(5 - 2) + 2;
			marks[i] = mark;
		}
		return marks;
	}
	
	//Считаем средний балл
	public double calcGPA(int[] marks) {
		double sum = 0, GPA = 0;
		
		for (int i = 0; i < 10; i++) {
			sum += marks[i];
		}
		GPA = sum/10;
		return GPA;
	}
	
	//Выводим сданные и не сданные экзамены
	public String[] debts(Subject[] sub) {
		String[] results = new String[5];
		for (int i = 0; i < 5; i++) {
			String result = "";
			String subject = sub[i].getSubject();
			boolean isPassExam = sub[i].getRandomBoolean();
			if (isPassExam) {
				result = subject + ": " + "is passed!";
			} else {
				result = subject + ": " + "isn`t passed :с";
			}
			results[i] = result;
		}
		return results;
	}
	
}