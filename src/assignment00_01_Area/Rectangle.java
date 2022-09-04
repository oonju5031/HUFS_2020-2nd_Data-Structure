package assignment00_01_Area;

class Rectangle extends Shape {
	private double width;
	private double height;
	public Rectangle(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	public void draw() {
		System.out.println("Rectangle: " + x + ", " + y + ", " + width + ", " + height);
	}
	public double getArea() {
		return (width * height);
	}
}