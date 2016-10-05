public class Task4Strings {
	
	public static void main(String[] args) {
		String s1 = args[0];
		String s2 = args[1];
		int length;
		String check = "";
		//abcd
		//abcdefg
		if (s1.length() > s2.length()) {
			length = s2.length();
			check =  s1.substring(0, length);
			if (s2.equals(check)) {
				System.out.println(s1 + " > " + s2);
			}
		} else if (s2.length() > s1.length()) {
			length = s1.length();
			check =  s2.substring(0, length);
			if (s1.equals(check)) {
				System.out.println(s1 + " < " + s2);
			}
		} else {
			if (s1.equals(s2)) {
				System.out.println(s1 + " = " + s2);
			}
			length = s1.length();
		}
		
		
		for (int i = 0; i < length; i++) {
			if (s1.charAt(i) > s2.charAt(i)) {
				System.out.println(s1 + " > " + s2);
				break;
			}
			if (s1.charAt(i) < s2.charAt(i)) {
				System.out.println(s1 + " < " + s2);
				break;
			}
		}
	}
}