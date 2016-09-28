public class Del9 {
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		if (n > 0) {
			for ( int i = 1; i <= (int) Math.sqrt(n); i++) {
				if (n % i == 0) {
					System.out.print(i + " ");
					if (i != (n / i)) {
						System.out.print((n / i) + " ");
					}
				}
			}
		} else {
			System.out.print("Number should be positive");		
		}
	}
}