public class SummFact3 {
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		double sum = 0;
		double fact1 = 1;
		double fact2 = 2;
		double result1 = 1;
		double result2 = 1;
		if (n > 0) {
			for (int m = 1; m <= n; m++) {
				fact1 = m - 1;
				for (int i = 1; i < fact1; i++) {
					result1 = result1 * (i + 1);
				}
				fact2 = 2 * m;
				for (int k = 1; k < fact2; k++) {
					result2 = result2 * (k + 1);
				}
				sum = sum + ((result1 * result1)/result2);
				result1 = 1;
				result2 = 1;
			}
			System.out.print(sum);
		} else {
			System.out.print("Oups..\"n\" should be > 0");
		}
	}
	
}