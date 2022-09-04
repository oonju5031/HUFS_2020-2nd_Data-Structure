package assignment00_01_Area;

class Circle extends Shape {
	public static final double PI = 3.14;
	private double radius;
	public Circle(double x, double y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	public void draw() {
		System.out.println("Circle: " + x + ", " + y + ", " + radius);
	}
	public double getArea() {
		return (PI * radius * radius);
	}
}