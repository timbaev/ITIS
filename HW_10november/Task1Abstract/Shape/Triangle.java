public class Triangle extends Shape {
	
	int a;
	int b;
	int c;
	
	public Triangle(int a, int b, int c) {
		name = "Triangle";
		countOfPoints = 3;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double square() {
		double p = (a + b + c) / 2;
		double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		return S;
	}
	
	public double perimeter() {
		return a + b + c;
	}
}