public class Task6Palindrome {
	
	public static void main(String[] args) {
		String string = args[0];
		int length = string.length();
		boolean equal = true;
		int check = length - 1;
		
		for (int i = 0; i < length/2; i++) {
			if (string.charAt(i) == string.charAt(check)) {
				check -= 1;
			} else {
				equal = false;
				System.out.println("This is word isn`t palindrome :c");
				break;
			}
		}
		
		if (equal) {
			System.out.println("This is word is palindrome!!");
		}
	}
}