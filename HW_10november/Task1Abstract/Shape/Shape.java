public abstract class Shape {
	
	protected int countOfPoints;
	protected String name;
	
	public abstract double square();
	public abstract double perimeter();
	
	public abstract String toString() {
		return "Name: " + name + "\n" +
		"\n" + "Count of points: " + countOfPoints +
		"\n" + "Square: " + square() + 
		"\n" + "Perimeter: " + perimeter() + "\n";
	}
}