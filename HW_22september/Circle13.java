public class Circle13 {
	
	public static void main(String[] args) {
		int r = Integer.parseInt(args[0]);
		if (r > 3) {
			double x; double y;
			for (int i = 1; i < (2 * r + 1); i++) {
				for (int j = 1; j < (2 * r + 1); j++) {
					x = r + Math.sqrt(r * r - (r - j) * (r - j));
					y = r - Math.sqrt(r * r - (r - j) * (r - j));
					if ((i > y) && (i < x)) {
						System.out.print("**");
					}
					else {
						System.out.print("  ");
					}
				}
				System.out.println();	
			}
		}
		else {
			System.out.println("Error..r should be > 3");
		}
	}
}