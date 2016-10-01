public class Task2Pascal {
	
	public static void main(String[] args) {
		int temp = 0;
		int newTemp = 2;
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
			int[] sumArray = new int[number];
			int[] numberArray = new int[number];
			numberArray[0] = 1;
			numberArray[number-1] = 1;
			for (int i = 1; i < number-1; i++) {
				numberArray[i] = number-1;
			}
			for (int i = 0; i < number; i++) {
				System.out.print(numberArray[i] + " ");
			}
		}
}