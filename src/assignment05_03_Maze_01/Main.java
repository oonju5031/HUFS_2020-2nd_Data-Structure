package assignment05_03_Maze_01;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	// 필요한 메소드가 있으면 작성하시오.
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
		
		// maze의 내부값을 입력받는다.
		for(int i = 0; i < sizeY; i++)
			for (int j = 0; j < sizeX; j++)
				maze[i][j] = scan.nextInt();
		
		scan.close();
		
		// mark의 모든 좌표값을 0으로 지정한다.
		for (int i = 0; i < sizeY; i++)
			for (int j = 0; j < sizeX; j++)
				mark[i][j] = 0;
		
		// 아래 코드를 작성하시오.
		mark[start.x][start.y] = 1;  // 시작점을 visit check
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
				
				maze[now.y][now.x] = -1;  // String으로 변환한 maze에서 *로 변환될 값 
				
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
		
		// 더 이상 갈 수 있는 곳이 없으면 결과를 출력
		// maze[][]는 정수를 저장하므로 *와 S, F를 출력할 수 없다.
		// 따라서 maze[][]를 새로운 String 이차원 배열을 작성해 maze의 값을 복사한다.
		String result[][] = new String[sizeY][sizeX];
		
		result[start.y][start.x] = "S"; 
		result[exit.y][exit.x] = "F";
		
		// maze를 result로 복사
		for (int i = 0; i < sizeY; i++)
			for (int j = 0; j < sizeX; j++) {
				result[i][j] = Integer.toString(maze[i][j]);
			}
		
		// *로 변환 및 출력
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