public class Main {
	
	static Control control = new Control();
	
	public static void main(String[] args) {
		control.add(new Point(2,5));
		control.add(new Point(3,-2));
		control.add(new Point(1,8));
		control.add(new Point(9,-5));
		control.add(new Point(0,3));
		control.remove(2);
		control.remove(3);
		control.get(0);
		printPoints();
	}
	
	public static void printPoints() {
		Point[] points = control.getPoints();
		for (int i = 0; i < points.length - 2; i++) {
			int x = points[i].getX();
			int y = points[i].getY();
			System.out.println("X:" + x + " " + "Y:" + y);
		}
	}
	
}