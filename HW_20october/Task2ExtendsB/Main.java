public class Main {
	
	public static void main(String[] args) {
		City kazan = new City("Russia", "Russian", "Putin", "Tatarstan", "Minnihanov", "Tatar", "Kazan", "Metshin", 1005);
		City elabuga = new City("Russia", "Russian", "Putin", "Tatarstan", "Minnihanov", "Tatar", "Elabuga", "Emelyanov", 1780);
		City elabuga2 = new City("Russia", "Russian", "Putin", "Tatarstan", "Minnihanov", "Tatar", "Elabuga", "Emelyanov", 1780);
		City elabugaClone = elabuga.clone();
		boolean equal = kazan.equals(elabuga);
		boolean _equal = elabuga.equals(elabugaClone);
		String kazanInfo = kazan.toString();
		int hashCode = elabuga.hashCode();
		System.out.println("Equal is: " + equal);
		System.out.println("_Equal is: " + _equal);
		System.out.println("hashCode Elabuga: " + hashCode);
		System.out.println("____________________________");
		System.out.println("Kazan info: " + "\n" + kazanInfo);
		System.out.println("_____________________________");
		System.out.println("Ekabuga  clone info: " + "\n" + elabugaClone.toString());
	}
}