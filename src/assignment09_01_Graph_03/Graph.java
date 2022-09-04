package assignment09_01_Graph_03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	// 필요한 field, method는 추가하시오.
	private int noVertex;
	private ArrayList<ArrayList<Integer>> graph;
	private boolean[] visited;
	
	// 생성자를 작성하시오.
	public Graph(int graphSize) {
		this.noVertex = graphSize;
		this.graph = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < graphSize + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		this.visited = new boolean[this.noVertex + 1];
	}
	
	// 간선 (i, j)를 삽입한다.
	public void addEdge(int i, int j) {
		graph.get(i).add(j);
		graph.get(j).add(i);
	}
	
	// 간선 (i, j)를 삭제한다.
	public void removeEdge(int i, int j) {
		
	}
	
	// BFS로 탐색하면서 방문하는 노드를 출력한다.
	public void bfs(int v) {
		Queue<Integer> q = new <Integer>LinkedList();
		
		q.offer(v);
		visited[v] = true;
		
		while (!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp);
		}
	}
	
	// DFS로 탐색하면서 방문하는 노드를 출력한다.
	public void dfs(int v) {
		this.visited[v] = true;
		System.out.print(v + " ");
		
		for (int i: graph.get(v)) {
			if (this.visited[i] == false)
				dfs(i);
		}
	}
	
	// 그래프를 출력하는 메소드이다.
	public void print() {
		for (int i = 1; i < graph.size(); i++) {
			System.out.print("i");
			
			for (int j = 0; j < graph.get(i).size(); j++)
				System.out.print(" " + graph.get(i).get(j));
		}
		System.out.println();
	}
		
}
