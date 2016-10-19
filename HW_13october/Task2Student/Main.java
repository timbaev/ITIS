import java.util.*;

public class Main{
	
	static Student[] stu = new Student[5];
	static Subject[] sub = new Subject[5];
	static University univer = new University();
	static String[] subjects;
	
	public static void main(String[] args) {
		enterData();
		outputData();
		ratingStudents();
	}
	
	public static void enterData() {
		stu[0] = new Student("Timur", "Shafigullin", 18, 2016);
		stu[1] = new Student("Misha", "Collins", 19, 2015);
		stu[2] = new Student("Nikolay", "Baskov", 20, 2014);
		stu[3] = new Student("Ekaterina", "Petrovna", 21, 2013);
		stu[4] = new Student("Adel", "Khalikov", 22, 2012);
		
		sub[0] = new Subject("English");
		sub[1] = new Subject("Algebra");
		sub[2] = new Subject("Discrete mathematics");
		sub[3] = new Subject("Physical culture");
		sub[4] = new Subject("Informatics");
	}
	
	public static void outputData() {
		for (int i = 0; i < 5; i++) {
			String name = stu[i].getName();
			String surname = stu[i].getSurname();
			int age = stu[i].getAge();
			int course = stu[i].getCourse();
			int[] marks = stu[i].getMarks();
			String marksStr = Arrays.toString(marks);
			double GPA = stu[i].getGPA();
			System.out.println("Name: " + name);
			System.out.println("Surname: " + surname);
			System.out.println("Age: " + age);
			System.out.println("Course: " + course);
			System.out.println("Marks: " + marksStr);
			System.out.println("GPA: " + GPA);
			subjects = stu[i].debts(sub);
			for (String v : subjects) {
				System.out.println(v);
			}
			System.out.println("---------------------------------------");
		}
	}
	
	public static void ratingStudents() {
		stu = univer.ratingStudents(stu);
		int k = 1;
		System.out.println("Rating KFU:");
		for (int i = 5; i >= 1; i--) {
			String name = stu[i-1].getName();
			String surname = stu[i-1].getSurname();
			System.out.println(k + " Position: " + name + " " + surname);
			k++;
		}
	}
}