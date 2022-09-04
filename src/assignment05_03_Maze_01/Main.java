package assignment05_03_Maze_01;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	// �ʿ��� �޼ҵ尡 ������ �ۼ��Ͻÿ�.
	public static Point myPoint(int a, int b, int c) {
		Point n = new Point(a, b, c);
		return n;
	}
	
	
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
		int mark[][] = new int[sizeY][sizeX];
		
		// maze�� ���ΰ��� �Է¹޴´�.
		for(int i = 0; i < sizeY; i++)
			for (int j = 0; j < sizeX; j++)
				maze[i][j] = scan.nextInt();
		
		scan.close();
		
		// mark�� ��� ��ǥ���� 0���� �����Ѵ�.
		for (int i = 0; i < sizeY; i++)
			for (int j = 0; j < sizeX; j++)
				mark[i][j] = 0;
		
		// �Ʒ� �ڵ带 �ۼ��Ͻÿ�.
		mark[start.x][start.y] = 1;  // �������� visit check
		Stack<Point> stack = new Stack<Point>();
		stack.push(myPoint(1, 1, 1));
		
		while (!stack.empty()) {
			Point now = stack.pop();
			int next_y, next_x = -1;
			
			while (now.dir <= 3) {
				if (now.dir == 0) {  // North
					next_y = now.y - 1;
					next_x = now.x;
				} else if (now.dir == 1) {  // East
					next_y = now.y;
					next_x = now.x + 1;
				} else if (now.dir == 2) {  // South
					next_y = now.y + 1;
					next_x = now.x;
				} else {  // West
					next_y = now.y;
					next_x = now.x - 1;
				}
				
				maze[now.y][now.x] = -1;  // String���� ��ȯ�� maze���� *�� ��ȯ�� �� 
				
				if (maze[next_y][next_x] == 0 && mark[next_y][next_x] == 0) {
					mark[next_y][next_y] = 1;
					stack.push(myPoint(now.y, now.x, now.dir));
					now.y = next_y;
					now.x = next_x;
					now.dir = 0;
				} else {
					now.dir += 1;
				}
			}
		}
		
		// �� �̻� �� �� �ִ� ���� ������ ����� ���
		// maze[][]�� ������ �����ϹǷ� *�� S, F�� ����� �� ����.
		// ���� maze[][]�� ���ο� String ������ �迭�� �ۼ��� maze�� ���� �����Ѵ�.
		String result[][] = new String[sizeY][sizeX];
		
		result[start.y][start.x] = "S"; 
		result[exit.y][exit.x] = "F";
		
		// maze�� result�� ����
		for (int i = 0; i < sizeY; i++)
			for (int j = 0; j < sizeX; j++) {
				result[i][j] = Integer.toString(maze[i][j]);
			}
		
		// *�� ��ȯ �� ���
		for (int i = 0; i < sizeY; i++) {
			for (int j = 0; j < sizeX; j++) {
				if (result[i][j] == "-1")
					result[i][j] = "*";
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}