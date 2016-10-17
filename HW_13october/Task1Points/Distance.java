public class Distance {
	
	public static void main(String[] args) {
		
	}
	
	public double distance(int[] points) {
		double x1 = points[0];
		double x2 = points[1];
		double y1 = points[2];
		double y2 = points[3];
		double dst = Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
		return dst;
	}
}