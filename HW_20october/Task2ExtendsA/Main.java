public class Main {
	
	static Lumia lumia = new Lumia();
	
	public static void main(String[] args) {
		lumia.setModel(lumia.getCompany() + " " + "Lumia 640");
		lumia.setOS("Windows Phone");
		lumia.setYear(2015);
		lumia.setMemory(8);
		lumia.setWeight(145);
		printInfo();
	}
	
	public static void printInfo() {
		System.out.println("Smartphone: " + lumia.getModel());
		System.out.println("OS: " + lumia.getOS());
		System.out.println("Year: " + lumia.getYear());
		System.out.println("Memory: " + lumia.getMemory());
		System.out.println("Weight: " + lumia.getWeight());
		System.out.println("__________________________");
		System.out.println("About Company: ");
		System.out.println("Company name: " + lumia.getCompany());
		System.out.println("Year of foundation: " + lumia.getYearFound());
		System.out.println("CEO: " + lumia.getDirector());
		System.out.println("Location: " + lumia.getLocation());
		System.out.println("Founder: " + lumia.getFounder());
	}
}