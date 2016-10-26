public class Main {
	
	public static void main(String[] args) {
		Lumia lumia640 = new Lumia("Lumia 640", "Windows Phone 8.1", 2015, 8, 145);
		Lumia lumia650 = new Lumia("Lumia 650", "Windows 10 Mobile", 2016, 16, 122);
		Lumia lumia640Clone = new Lumia("Lumia 640", "Windows Phone 8.1", 2015, 8, 145);
		boolean objectsEqual1 = lumia640.equals(lumia650);
		boolean objectsEqual2 = lumia640.equals(lumia640Clone);
		String infoLumia650 = lumia650.toString();
		int hashCode = lumia640.hashCode();
		Lumia lumia650new = lumia650.clone();
		String infoLumia650new = lumia650new.toString();
		
		System.out.println("objectsEqual1 is " + objectsEqual1); //false
		System.out.println("objectsEqual2 is " + objectsEqual2); //true
		System.out.println("____________________________");
		System.out.println("Lumia 650: " + "\n" + infoLumia650); //Info
		System.out.println("____________________________");
		System.out.println("hashCode Lumia640: " + hashCode); //hashCode
		System.out.println("____________________________");
		System.out.println("Lumia 650 copy: " + "\n" + infoLumia650new); //Info
		System.out.println("____________________________");
		printAboutCompany(lumia640);
	}
	
	public static void printAboutCompany(Lumia lumia) {
		System.out.println("About Company: ");
		System.out.println("Company name: " + lumia.getCompany());
		System.out.println("Year of foundation: " + lumia.getYearFound());
		System.out.println("CEO: " + lumia.getDirector());
		System.out.println("Location: " + lumia.getLocation());
		System.out.println("Founder: " + lumia.getFounder());
	}
}