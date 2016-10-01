import java.util.Arrays;
public class Task1Bubble {
	
	public static void main(String[] args) {
		int[] array = {5, 1, 2, 9, 0, 3};
		boolean isSwaped = true;
		int size = array.length;
		
		while (isSwaped) {
			isSwaped = false;
			for (int i = 1; i < size; i++) {
				if (array[i] < array[i-1]) {
					int temp = array[i];
					array[i] = array[i-1];
					array[i-1] = temp;
					isSwaped = true;
				}
			}
		}
		for (int v : array) {
			System.out.print(v + " ");
		}
	}
}