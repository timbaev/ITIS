public class Main {
	
	static Array array = new Array();
	static Control control = new Control();
	
	public static void main(String[] args) {
		control.add(5);
		control.add(3);
		control.add(4);
		control.add(1);
		control.add(13);
		control.remove(3);
		control.printArray();
	}
	
	public static void printArray() {
		int[] points = array.getPoints();
		for (int v : points) {
			System.out.print(v + " ");
		}
	}
}