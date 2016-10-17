import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		//Точки подаются в формате: x1,x2,y1,y2
		int[] pointsFile = new int[4];
		int[] pointsUser = new int[4];
		double dist;
		Point point = new Point();
		Distance dst = new Distance();
		System.out.print("Select an input method: 0 or 1 (0 - File; 1 - Scanner):");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if (n == 0) {
			pointsFile = point.getPointsFile();
			dist = dst.distance(pointsFile);
		} else {
			pointsUser = point.getPointsUser();
			dist = dst.distance(pointsUser);
		}	
		System.out.println("Distance = " + dist);
	}
}