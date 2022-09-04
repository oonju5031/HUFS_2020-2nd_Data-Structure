package assignment01_02_Equals;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x1 = Integer.parseInt(br.readLine());
		int y1 = Integer.parseInt(br.readLine());
		int x2 = Integer.parseInt(br.readLine());
		int y2 = Integer.parseInt(br.readLine());
		
		Point point1 = new Point(x1, y1);
		Point point2 = new Point(x2, y2);
		
		System.out.println(point1.equals(point2));
	}

}
