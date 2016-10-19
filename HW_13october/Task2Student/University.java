import java.util.*;

public class University{
	
	public Student[] ratingStudents(Student[] students) {
		int l = 0;
		double[] GPA = new double[5]; //храним средние баллы студентов
		
		for (int i = 0; i < 5; i++) {
			GPA[i] = students[i].getGPA();
		}
		Arrays.sort(GPA);
		
		for (int i = 0; i < 5; i++) {
			for (int k = 0; k < 5; k++) {
				if (GPA[i] == students[k].getGPA()) {
					Student student = students[i];
					students[i] = students[k];
					students[k] = student;
					break;
				}
			}
		}
		return students;
	}
}