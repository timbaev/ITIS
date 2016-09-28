public class Progression4 {
	
	public static void main(String[] args) {
		int a1 = Integer.parseInt(args[0]);
		int a2 = Integer.parseInt(args[1]);
		int k = Integer.parseInt(args[2]);
		int d = a2 - a1;
		int sum = a1 + (k - 1) * d;
		/*for (int i = 1; i < k; i++) {
			sum = sum + d;
		}*/
		System.out.print(sum);
	}
}