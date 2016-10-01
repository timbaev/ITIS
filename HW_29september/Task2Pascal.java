public class Task2Pascal {
	
	static int[] sumArray = new int[10];
	
	public static void main(String[] args) {
		boolean check = true;
		
		for (int i = 1; i <= 10; i++) {
			for (int k = 1; k <= 10 - i; k++) {
				System.out.print(" ");
			}
			numberBuilder(i);
			System.out.println();
		}
	}
	
	public static void numberBuilder(int number) {
			int[] numberArray = new int[number];
			numberArray[0] = 1;
			numberArray[number-1] = 1;
			for (int i = 1; i < number-1; i++) {
				numberArray[i] = sumArray[i-1];
			}
			for (int i = 0; i < number; i++) {
				System.out.printf(numberArray[i] + " ");
			}
			for (int i = 0; i < number - 1; i++) {
				sumArray[i] = numberArray[i] + numberArray[i+1];
			}
		}
}