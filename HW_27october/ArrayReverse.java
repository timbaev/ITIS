import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayReverse {
	
	public static void main(String[] args) {
		Random random = new Random();
		Integer[] numbers = new Integer[10];
		Integer[] reversedNum;
		String numStr;
		int reversedNumbers;
		//Заполняем рандомными числами
		for (int i = 0; i < numbers.length; i++) {
			int randomInt = random.nextInt(100);
			numbers[i] = randomInt;
		}
		//Выводим первоначальный массив
		numStr = Arrays.toString(numbers);
		System.out.println("Array before sorting: " + numStr);
		//Получаем перевёрнутый массив и выводим
		reversedNum = reverseNumbers(numbers);
		numStr = Arrays.toString(reversedNum);
		System.out.println("Array after sorting: " + numStr);
		//Получаем перевёрнутый массив посредством Java и выводим
		reversedNum = reverseByJava(numbers);
		numStr = Arrays.toString(reversedNum);
		System.out.println("Array after sorting by Java: " + numStr);
	} 
	
	public static Integer[] reverseNumbers(Integer[] numbers) {
		int size = numbers.length;
		Integer[] reversedNumbers = new Integer[size];
		for (int i = 0; i < size; i++) {
			reversedNumbers[i] = numbers[size - 1 - i];
		}
		return reversedNumbers;
	}
	
	public static Integer[] reverseByJava(Integer[] numbers) {
		List arr = Arrays.asList(numbers);
		Collections.reverse(arr);
		
		return (Integer[]) arr.toArray(new Integer[numbers.length]);
	}
	
}