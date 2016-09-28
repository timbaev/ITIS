public class PI {
	
	public static void main(String[] args) {
		int r = Integer.parseInt(args[0]);
		double a;
		double sum = 1;
		for (int i = 0; i < 10000; i++) {
			a = r * Math.sqrt(2 - 2 * Math.cos(i));
			sum = sum * a;
		}
		System.out.print(sum);
	}
}