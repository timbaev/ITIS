public class Main {
	
	public static void main(String[] args) {
		Circle circle = new Circle(5);
		Square square = new Square(5);
		Triangle triangle = new Triangle(5, 6, 7);
		System.out.println(circle.toString());
		System.out.println(square.toString());
		System.out.println(triangle.toString());
	}
}