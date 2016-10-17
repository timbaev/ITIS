import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Point {
	int[] points = new int[4];
	
	public static void main(String[] args) {
		
	}
	
	public int[] getPointsFile() {
		
		try{
			File file = new File("C://Files", "Points.txt");
			Scanner scanner = new Scanner(file).useDelimiter(",");
			
			for (int i = 0; i <= 3; i++) {
				points[i] = scanner.nextInt();
			}
		} catch (FileNotFoundException e) {
			
		}
		return points;
	}
	
	public int[] getPointsUser() {
		Scanner scanner = new Scanner(System.in);
		String pointsStr = scanner.nextLine();
		String newPointsStr = pointsStr.replaceAll(",", " ");
		Scanner sc = new Scanner(newPointsStr);
		for (int i = 0; i <= 3; i++) {
			points[i] = sc.nextInt();
		}
		return points;
	}
}