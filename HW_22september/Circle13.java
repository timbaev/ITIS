public class Circle13 {
	
	public static void main(String[] args) {
		try {
			int n = Integer.parseInt(args[0]) - 1;	
			if (n > 0) {
				for (int i = -n; i <= n; i++) {
					for (int j = -n; j <= n; j++) {
						if (i * i + j * j <= n * n + n / 3) 
							System.out.print("* ");
						else
							System.out.print("  ");
					}
					System.out.println();
				}		
			} else {
				System.out.println("Error..number should be positive");
			}
		} catch (NumberFormatException e) {
			System.out.println("Error..input data is not correct");
		}
	}
}