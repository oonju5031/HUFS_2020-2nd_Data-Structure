package assignment05_03_Maze_00;

import java.util.Scanner;

public class Main {
	
	// �ʿ��� �޼ҵ尡 ������ �ۼ��Ͻÿ�.
	
	
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int sizeX = scan.nextInt();
		int sizeY = scan.nextInt();
		
		Point start = new Point();
		start.x = scan.nextInt();
		start.y = scan.nextInt();
		
		Point exit = new Point();
		exit.x = scan.nextInt();
		exit.y = scan.nextInt();
		
		int maze[][] = new int[sizeY][sizeX];
		
		for(int i = 0; i < sizeY; i++)
			for (int j = 0; j < sizeX; j++)
				maze[i][j] = scan.nextInt();
		
		// �Ʒ� �ڵ带 �ۼ��Ͻÿ�.
		
		
		scan.close();
	}
}