import java.util.Random;

public abstract class Car {
	
	protected int maxSpeed;
	protected double fuelUsage;
	protected String name;
	protected int countOfWheels = 4;
	
	public int rating() {
		Random random = new Random();
		int raiting = random.nextInt(10);
		return raiting;
	}
	
	public void beep() {
		System.out.println("Beeep-beeeep");
	}
	
	public abstract void driveWithMaxSpeed();
}