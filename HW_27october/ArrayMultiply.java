import java.util.Random;
import java.util.Arrays;

public class ArrayMultiply {
	
	public static void main(String[] args) {
		long[] numbers = new long[10];
		Random random = new Random();
		numbers[0] = random.nextInt(10);
		numbers[1] = random.nextInt(10);
		
		for (int i = 2; i < numbers.length; i++) {
			numbers[i] = numbers[i - 1] * numbers[i - 2];
		}
		String result = Arrays.toString(numbers);
		System.out.println("Result: " + result);
	}
}