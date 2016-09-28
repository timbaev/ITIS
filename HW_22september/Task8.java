public class Task8 {
	
	public static void main(String[] args) {
		int numb = Integer.parseInt(args[0]); 
		int twoNumb;
		int k = 0;
		int max = 0;
		String numbStr = "";
		String newNumbStr = "";
		
		if (numb <= 0) {
			System.out.println("error..number should be positive, please, try again");
			System.exit(0);
		}
		
		while (numb > 0) {
			twoNumb = numb % 2;
			if (twoNumb == 1) {
				numbStr += "1";
			} else {
				numbStr += "0";
			}
			numb /= 2;
		}
		
		char[] a = numbStr.toCharArray();
		int length = a.length;
		
		for (int i = 1; i <= length - 1; i++) {
			if (a[i] == a[i-1]) {
				k++;
			} else if (k > max) {
				max = k;
				k = 1;
			}
		}
		System.out.println("Count = " + max);
	}
}