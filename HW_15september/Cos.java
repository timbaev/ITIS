public class Cos {
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int x = Integer.parseInt(args[1]);
		double cos = Math.cos(Math.toRadians(x));
		for (int i = 1; i < n; i++) {
			cos = Math.cos(Math.toRadians(x + cos));
		}
		System.out.print(cos);
	}
}