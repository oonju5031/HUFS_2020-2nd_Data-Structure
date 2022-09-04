package assignment09_01_Graph;

import java.util.Scanner;

public class Main {
	
	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		int noVertex = scan.nextInt();
		Graph graph = new Graph(noVertex);

		for(int i = 0; i < noVertex; i++) {
			for(int j = 0; j < noVertex; j++) {
				int vertex = scan.nextInt();
				if (vertex == 1)
					graph.addEdge(i, j);
			}
		}
		
		
		while(scan.hasNext()) {
			String cmd = scan.next();
			if (cmd.equals("P"))
				graph.print();
			else if (cmd.equals("I")) {
				int from = scan.nextInt();
				int to = scan.nextInt();
				graph.addEdge(from, to);
			} else if (cmd.equals("D")) {
				int from = scan.nextInt();
				int to = scan.nextInt();
				graph.removeEdge(from, to);
			} else if (cmd.equals("DFS")) {
				int vertex = scan.nextInt();
				graph.dfs(vertex);
			} else if (cmd.equals("BFS")) {
				int vertex = scan.nextInt();
				graph.bfs(vertex);
			} else if (cmd.equals("E")) { // 종료한다.
				break;
			}
		}
		
		scan.close();		
	}
}