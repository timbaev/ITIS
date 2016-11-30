public class Task6 {
	
	public static void main(String[] args) {
		try {
			int a = Integer.parseInt(args[0]);
			int k = Integer.parseInt(args[1]);
			int twoNumb = 0;
			int sum = 0;
			String result = "";
			String newResult = "";
			
			if ((a <= 0) || (k < 2) || (k > 11)) {
				System.out.println("oups..number should be positive and numeral system 2 <= k <= 10");
				System.exit(0);
			}
			
			while (a > 0) {
				twoNumb = a % k;
				result += twoNumb;
				sum += twoNumb;
				a /= k;
			}
			
			char resultArray [] = result.toCharArray();
			int length = resultArray.length;
			for (int i = length - 1; i >= 0; i--) {
				newResult += resultArray[i];
			}
			System.out.println("Sum = " + sum);
			System.out.println("Result = " + newResult);
		} catch (NumberFormatException e) {
			System.out.println("Error..input data is not correct");
		}
	}
}