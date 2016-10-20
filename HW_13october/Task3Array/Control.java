public class Control {
	
	Point[] points;
	int size = 0;
	
	public Point[] getPoints() {
		return points;
	}
	
	public void add(Point point) {
		
		if (size != 0) {
			size = points.length;
			Point[] newPoints = new Point[size+1];
			System.arraycopy(points, 0, newPoints, 0, size);
			newPoints[size] = point;
			points = newPoints;
		} else {
			points = new Point[1];
			points[0] = point;
			size = points.length;
		}
	}
	
	public void remove(int index) {
		size = points.length;
		if (index >= size) {
			System.out.println("Error index > then size of Array");
		} else {
			System.arraycopy(points, index + 1, points, index, size - index - 1);
			size--;
			points[size] = null;
		}
	}
	
	public Point get(int index) {
		size = points.length;
		if (index >= size) {
			System.out.println("Error index > then size of Array");
		} else {
			return points[index];
		}
		return null;
	}
}
	