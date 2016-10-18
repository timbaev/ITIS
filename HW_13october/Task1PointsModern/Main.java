import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	static GetDistance distance = new GetDistance();
	static double d;
	static Point point1 = new Point();
	static Point point2 = new Point();
	static int[] points = new int[4];
	
	public static void main(String[] args) {
		//Работа через консоль
		point1 = enterPoint();
		point2 = enterPoint();
		d = distance.lengthPoint(point1, point2);
		System.out.println("Distance from scanner = " + d);
		//Работа через файл
		point1 = enterPointFile(0);
		point2 = enterPointFile(2);
		d = distance.lengthPoint(point1, point2);
		System.out.println("Distance from file = " + d);
	}
	
	public static Point enterPoint() {
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		Point newPoint = new Point(x, y);
		return newPoint;
	}
	
	public static Point enterPointFile(int k) {
		try{
			File file = new File("C://Files", "Points.txt");
			Scanner sc = new Scanner(file).useDelimiter(",");
			String pointsStr = sc.nextLine();
			String newPointsStr = pointsStr.replaceAll(",", " ");
			Scanner scPoint = new Scanner(newPointsStr);
			for (int i = 0; i <= 3; i++) {
				points[i] = scPoint.nextInt();
			}
			Point newPoint = new Point(points[k], points[k+1]);
			return newPoint;
		} catch (FileNotFoundException e) {
			
		}
		return null;
	}
}