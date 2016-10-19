public class Control {
	
	Array array = new Array();
	boolean firstStart = true;
	
	public void add(int x) {
		int[] point = array.getPoints();
		int[] newPoint;
		if (firstStart) {
			newPoint = new int[1];
			newPoint[0] = x;
		} else {
			int count = point.length;
			newPoint = new int[count + 1];
			System.arraycopy(point, 0, newPoint, 0, count);
			newPoint[count] = x;
		}
		firstStart = false;
		array.setPoints(newPoint);
	}
	
	public void remove(int i) {
		int[] point = array.getPoints();
		int count = point.length;
		int[] newPoint = new int[count - 1];
		System.arraycopy(point, 0, newPoint, 0, i-1);
		System.arraycopy(point, i, newPoint, i-1, count - i);
		array.setPoints(newPoint);
	}
	
	public int get(int i) {
		int[] point = array.getPoints();
		int x = point[i];
		return x;
	}
	
	public void printArray() {
		int[] point = array.getPoints();
		for (int v : point) {
			System.out.print(v + " ");
		}
	}
}