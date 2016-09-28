public class NOD11 {
	
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int nod;
		int max = 0;
		int a1 = a;
		int b1 = b;
		
		if ((a > 0) && (b > 0)) {
			//Метод Евклида
			long startEuklid = System.nanoTime();
			while ((a != 0) && (b != 0)) {
				if (a > b) {
					a = a % b;
				} else {
					b = b % a;
				}
			}
			nod = a + b;
			long endEuklid = System.nanoTime();
			long resultEuklid = endEuklid - startEuklid;
			System.out.println("NOD by Euklid: " + nod);
			System.out.println("Time Euklid method: " + resultEuklid + " ns");
		
			//Метод перебора
			long startFingering = System.nanoTime();
			if (a1 < b1) {
				for (int i = 1; i <= a1; i++) {
					if ((a1 % i == 0) && (b1 % i == 0)) {
						max = i;
					}	
				}
			} else {
				for (int i = 1; i <= b1; i++) {
					if ((a1 % i == 0) && (b1 % i == 0)) {
						max = i;
					}
				}
			}
			long endFingering = System.nanoTime();
			long resultFingering = endFingering - startFingering;
			System.out.println("NOD by fingering: " + max);
			System.out.println("Time fingering method: " + resultFingering + " ns");
		} else {
			System.out.println("error..numbers should be positive");
		}
	}
}