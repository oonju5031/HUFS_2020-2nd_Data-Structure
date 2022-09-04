package assignment09_01_Graph_03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	// �ʿ��� field, method�� �߰��Ͻÿ�.
	private int noVertex;
	private ArrayList<ArrayList<Integer>> graph;
	private boolean[] visited;
	
	// �����ڸ� �ۼ��Ͻÿ�.
	public Graph(int graphSize) {
		this.noVertex = graphSize;
		this.graph = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < graphSize + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		this.visited = new boolean[this.noVertex + 1];
	}
	
	// ���� (i, j)�� �����Ѵ�.
	public void addEdge(int i, int j) {
		graph.get(i).add(j);
		graph.get(j).add(i);
	}
	
	// ���� (i, j)�� �����Ѵ�.
	public void removeEdge(int i, int j) {
		
	}
	
	// BFS�� Ž���ϸ鼭 �湮�ϴ� ��带 ����Ѵ�.
	public void bfs(int v) {
		Queue<Integer> q = new <Integer>LinkedList();
		
		q.offer(v);
		visited[v] = true;
		
		while (!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp);
		}
	}
	
	// DFS�� Ž���ϸ鼭 �湮�ϴ� ��带 ����Ѵ�.
	public void dfs(int v) {
		this.visited[v] = true;
		System.out.print(v + " ");
		
		for (int i: graph.get(v)) {
			if (this.visited[i] == false)
				dfs(i);
		}
	}
	
	// �׷����� ����ϴ� �޼ҵ��̴�.
	public void print() {
		for (int i = 1; i < graph.size(); i++) {
			System.out.print("i");
			
			for (int j = 0; j < graph.get(i).size(); j++)
				System.out.print(" " + graph.get(i).get(j));
		}
		System.out.println();
	}
		
}
