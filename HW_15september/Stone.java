public class Stone {
	
	public static void main(String[] args) {
		int t = Integer.parseInt(args[0]);
		if (t > 0) {
			System.out.print(9.8*t*t/2);
		} else {
			System.out.print("time can`t be negative");
		}
	}
}