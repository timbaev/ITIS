public class Square extends Shape {
	int a;
	
	public Square(int a) {
		name = "Square";
		countOfPoints = 4;
		this.a = a;
	}
	
	public double square() {
		return a * a;
	}
	
	public double perimeter() {
		return 4 * a;
	}
}