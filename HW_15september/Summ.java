public class Summ {
	
	public static void main(String[] args) {
		double S = 1;
		double d = 3;
		int n = Integer.parseInt(args[0]);
		for (int i = 1; i < n; i++) {
			if (i % 2 != 0) {
				S = S - (1/(d*d));
				d = d + 2;
			}
			else {
				S = S + (1/(d*d));
				d = d + 2;
			}
		}
		System.out.print(S);
	}
}