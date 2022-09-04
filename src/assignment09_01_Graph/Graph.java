package assignment09_01_Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	
	// �ʿ��� field, method�� �߰��Ͻÿ�.
	private int noVertex;
	private int[][] myGraph;
	private int[] visited;  // visited 1, not visited 0
	
	// �����ڸ� �ۼ��Ͻÿ�.
	public Graph(int noVertex) {
		this.noVertex = noVertex;
		myGraph = new int[noVertex][noVertex];
		
		for (int i = 0; i < noVertex; i++) {
			for (int j = 0; j < noVertex; j++) {
				myGraph[i][j] = 0;
			}
		}
	}
	
	// ���� (i, j)�� �����Ѵ�.
	public void addEdge(int i, int j) {
		myGraph[i][j] = 1;
	}
	
	// ���� (i, j)�� �����Ѵ�.
	public void removeEdge(int i, int j) {
		myGraph[i][j] = 0;
	}
	
	// BFS�� Ž���ϸ鼭 �湮�ϴ� ��带 ����Ѵ�.
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
	
	// DFS�� Ž���ϸ鼭 �湮�ϴ� ��带 ����Ѵ�.
	public void dfs(int init) {
		visited = new int[noVertex];
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(init);
		
		while(!stack.isEmpty()) {
			int x = stack.pop();
			
			if (visited[x] == 0) {
				visited[x] = 1;
				System.out.print(x + " ");
				
				for (int i = 0; i < noVertex; i++) {
					if (adjacency(x, i) && visited[i] == 0)
						stack.push(i);
				}
			}
		}
		System.out.println();
	}
	
	// �� ������ ������ ������ true, �ƴϸ� false�� ��ȯ�Ѵ�.
	public boolean adjacency(int x, int y) {
		if (myGraph[x][y] == 1)
			return true;
		return false;
	}
	
	// �׷����� ����ϴ� �޼ҵ��̴�.
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
