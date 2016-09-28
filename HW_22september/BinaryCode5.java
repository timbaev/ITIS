public class BinaryCode5 {
	
	public static void main(String[] args) {
		int numb = Integer.parseInt(args[0]);
		int k = 0; 
		int twoNumb;
		String numbStr = "";
		String newNumbStr = "";
		while (numb > 0) {
			twoNumb = numb % 2;
			if (twoNumb == 1) {
				k++;
				numbStr += "1";
			} else {
				numbStr += "0";
			}
			numb /= 2;
		}
		char[] a = numbStr.toCharArray();
		int length = a.length;
		for (int i = length - 1; i >= 0; i--) {
			newNumbStr += a[i];
		}
	
		System.out.println("Count: " + k);
		System.out.println("Binary Code: " + newNumbStr);
	}
}