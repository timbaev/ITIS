public class Task5TwoStrings {
	
	public static void main(String[] args) {
		String s1 = args[0]; //abcde
		String s2 = args[1]; //cde
		int length1 = s1.length();
		int length2 = s2.length();
		boolean check = false;
		
		if (length1 > length2) {
			for (int i = 0; i < length2; i++) {
				if (s1.charAt(i) == s2.charAt(0)) {
					String newS1 = s1.substring(i, length1);
					if (s2.equals(newS1)) {
						check = true;
						System.out.println("This String is included in " + i + " index");
						break;
					}
				}
			}
		} else if (s2.length() > s1.length()) {
			for (int i = 0; i < length1; i++) {
				if (s2.charAt(i) == s1.charAt(0)) {
					String newS2 = s2.substring(i, length2);
					if (s1.equals(newS2)) {
						check = true;
						System.out.println("This String is included in " + i + " index");
						break;
					}
				}
			}
		}
		
		if (!check) {
			System.out.println("This String isn`t included in here");
		}
	}
}