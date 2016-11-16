public class Audi extends Car {
	
	int rating;
	
	public Audi() {
		maxSpeed = 156;
		fuelUsage = 18.9;
		name = "Audio 100";
		rating = rating();
	}
	
	public void driveWithMaxSpeed() {
		try{
			if (rating > 5) {
				beep();
				System.out.println("Vrum-vrum, motherf*cker");
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("You car can`t do this :c");
		}
	}
	
	public String toString() {
		return "Max speed: " + maxSpeed + "\n" + "fuel Usage: " + fuelUsage 
		+ "\n" + "Name: " + name + "\n" + "Raiting: " + rating;
	}
}