package assignment09_01_Graph_01;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	// 필요한 field, method는 추가하시오.
	private int noVertex;
	private int[][] myGraph;
	private int[] visited;  // visited 1, not visited 0
	
	// 생성자를 작성하시오.
	public Graph(int noVertex) {
		this.noVertex = noVertex;
		myGraph = new int[noVertex + 100][noVertex + 100];
		visited = new int[noVertex + 100];
	}
	
	// 간선 (i, j)를 삽입한다.
	public void addEdge(int i, int j) {
		myGraph[i][j] = 1;
	}
	
	// 간선 (i, j)를 삭제한다.
	public void removeEdge(int i, int j) {
		myGraph[i][j] = 0;
	}
	
	// BFS로 탐색하면서 방문하는 노드를 출력한다.
	public void bfs(int init) {
		visited = new int[noVertex];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 0; i < noVertex; i++)
			visited[i] = 0;
		
		visited[init] = 1;
		queue.offer(init);
		System.out.print(init + " ");
		
		while (!queue.isEmpty()) {
			int x = queue.poll();
			if (visited[x] == 0) {
				visited[x] = 1;
				System.out.print(x + " ");
			}
			for (int i = 0; i < noVertex; i++) {
				if (adjacency(x, i) && visited[i] == 0)
					queue.offer(i);
			}
		}
		System.out.println();
	}
	
	// DFS로 탐색하면서 방문하는 노드를 출력한다.
	public void dfs(int init) {
		visited[init] = 1;
		System.out.print(init + " ");
		
		for (int i = 1; i < noVertex; i++) {
			if (myGraph[init][i] == 1 && visited[i] == 0)
				dfs(i);
		}
	}
	
	// 두 정점이 인접해 있으면 true, 아니면 false를 반환한다.
	public boolean adjacency(int x, int y) {
		if (myGraph[x][y] == 1)
			return true;
		return false;
	}
	
	// 그래프를 출력하는 메소드이다.
	public void print() {
		for (int i = 0; i < noVertex; i++) {
			String result = "";
			result += i + " ";
			
			for (int j = 0; j < noVertex; j++) {
				if (myGraph[i][j] == 1)
					result += j + " ";
			}
			
			result = result.trim();
			System.out.println(result);
		}
	}
}
