public class TwoInt1 {
	
	public static void main(String[] args) {
		int a = 5;
		int b = 7;
		
		a = b - a; //a = 2
		b = b - a; //b = 5
		a = b + a; //a = 7
		System.out.print("a = " + a + " b = " + b);
	}
}