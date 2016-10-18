public class GetDistance {
		
	public static double lengthPoint(Point point1, Point point2) {
		int x0 = point1.getX();
		int y0 = point1.getY();
		int x1 = point2.getX();
		int y1 = point2.getY();
		double d = Math.sqrt((x1 - x0)*(x1 - x0) + (y1 - y0)*(y1 - y0));
		return d;
	}
}