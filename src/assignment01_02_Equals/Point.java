package assignment01_02_Equals;

public class Point {
	public int x;
	public int y;
	
	public Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object obj) {
		Point a = (Point) obj;
		if ((x == a.x) && (y == a.y)) {
			return true;
		} else {
			return false;
		}
	}

}
