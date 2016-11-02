import java.util.Random;
import java.util.Arrays;

public class ArraySquare {
	
	public static void main(String[] args) {
		Random random = new Random();
		long[] numbers = new long[10];
		numbers[0] = random.nextInt(10);
		for (int i = 1; i < numbers.length; i++) {
			numbers[i] = numbers[i - 1] * numbers[i - 1];
		}
		String result = Arrays.toString(numbers);
		System.out.println("Result: " + result);
	}
}