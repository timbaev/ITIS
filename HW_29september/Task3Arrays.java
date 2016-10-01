import java.util.Arrays;
public class Task3Arrays {
	
	public static void main(String[] args) {
		int[] array1 = {8, 5, 6, 10, -13, 52};
		int[] array2 = {6, 10, -13, 52};
		int size1 = array1.length;
		int size2 = array2.length;
		int[] comparingArray = new int[size2];
		boolean check = false;
		int element = 0;
		int k = 1;
		
		for (int i = 0; i < size1; i++) {
			if (array1[i] == array2[0]) {
				System.arraycopy(array1, i, comparingArray, 0, size2);
				if (Arrays.equals(comparingArray, array2) == true) {
					System.out.println("Array input line item: " + i);
					check = true;
					break;
				}
			}
		}
		if (check == false) {
			System.out.println("Array doesn`t enter");
		}
	}
}