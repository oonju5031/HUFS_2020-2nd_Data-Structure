package assignment00_01_Area;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noShape = scan.nextInt();
		Shape[] shapes = new Shape[noShape];
		
		for (int i = 0; i < noShape; i++) {
			String s = scan.next();
			if (s.equals("Rectangle")) {
				double x, y, width, height;
				x = scan.nextDouble();
				y = scan.nextDouble();
				width = scan.nextDouble();
				height = scan.nextDouble();
				shapes[i] = new Rectangle(x, y, width, height);
			} else if (s.equals("Circle")) {
				double x, y, radius;
				x = scan.nextDouble();
				y = scan.nextDouble();
				radius = scan.nextDouble();
				shapes[i] = new Circle(x, y, radius);
			}
		}
		
		double sumArea = 0;
		for (Shape shape : shapes) {
			sumArea += shape.getArea();
		}
		System.out.printf("%.2f", sumArea);
		
		scan.close();
	}
}
