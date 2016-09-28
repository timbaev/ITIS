public class Fact2 {
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int result = 1;
		if (n == 0) {
			System.out.print("Factorial = 1");
		} else if (n < 0) {
			System.out.print("Oups..error");
		}
		if (n > 0) {
			for (int i = 1; i < n; i++) {
				result = result * (i + 1);
			}
			System.out.print("Factorial = " + result);
		}
	}
}