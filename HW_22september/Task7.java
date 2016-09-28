public class Task7 {
	
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		int numbTwo = 0;
		int number = 0;
		int sum = 0;
		String numeralSystem = "";
		char letter;
		String result = "";
		int x = 65;
		char[] letterArray = new char[26];
		
		if ((a <= 0) || (k < 2) || (k > 36)) {
			System.out.println("oups..numbers should be: a > 0, 2 <= k <= 36");
			System.exit(0);
		}
		
		for (int i = 0; i <= 25; i++) {
			letterArray[i] = (char) x;
			x++;
		}
		
		while (a > 0) {
			numbTwo = a % k;
			if (numbTwo <= 9) {
				numeralSystem += numbTwo;
			} else {
				letter = letterArray[numbTwo - 10];
				numeralSystem += letter;
			}
			sum += numbTwo;
			a /= k;
		}
		
		char resultArray [] = numeralSystem.toCharArray();
		int length = resultArray.length;
		for (int i = length - 1; i >= 0; i--) {
			result += resultArray[i];
		}
		System.out.println("Sum = " + sum);
		System.out.println("Result = " + result);
	}
}