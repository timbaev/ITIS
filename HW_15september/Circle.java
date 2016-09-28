public class Circle {
	
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		int x0 = Integer.parseInt(args[2]);
		int y0 = Integer.parseInt(args[3]);
		int r = Integer.parseInt(args[4]);
		if (r > 0) {
			int distance = Distation(x, y, x0, y0);
			if (distance > r) {
				System.out.print("out circle");
			} else {
				System.out.print("in circle");
			}
		} else {
			System.out.print("Oups..incorret radius");
		}
	}
	
	public static int Distation(int x, int y, int x0, int y0) {
		double D = Math.sqrt((x - x0) * (x - x0) + (y - y0) * (y - y0));
		return Math.abs((int) D);
	}
}