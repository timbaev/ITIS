public class NOK10 {
	
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		if ((a > 0) && (b > 0)) {
			int nok = a * b;
		
			//Èùåì ÍÎÄ
			while ((a != 0) && (b != 0)) {
				if (a > b) {
					a = a % b;
				} else {
					b = b % a;
				}
			}
			int nod = a + b;
			//Èùåì ÍÎÊ
			nok = nok/nod;
			System.out.println("NOK: " + nok);
		} else {
			System.out.println("Oups..numbers should be positive..");
		}
	}
}