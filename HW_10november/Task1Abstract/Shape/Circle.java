public class Circle extends Shape {
	
	private int r;
	
	public Circle(int r) {
		name = "circle";
		countOfPoints = 0;
		this.r = r;
	}
	
	public double square() {
		return Math.PI * r * r;
	}
	
	public double perimeter() {
		return 2 * Math.PI * r;
	}
}