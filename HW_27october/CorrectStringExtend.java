public class CorrectStringExtend {
	static int squareOpenCount;
	static int squareCloseCount;
	static int figureOpenCount;
	static int figureCloseCount;
	
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
	}
	
	public static String checkStr(String str) {
		str = str.replaceAll("\\w|\\d", "");
		
		isCorrect = false;
		if (str.charAt(0) == '(') {
			openCount++;
		} else {
			closeCount++;
		}
		if (closeCount > openCount) {
			return null;
		}
		if (openCount == closeCount) {
			isCorrect = true;
		}
		if (str.length() != 1) {
			return checkStr(str.substring(1, str.length()));
		}
		return null;
	}
}