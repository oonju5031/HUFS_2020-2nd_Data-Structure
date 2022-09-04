package assignment09_01_Graph_02;

public class Graph {
	
	// �ʿ��� field, method�� �߰��Ͻÿ�.
	GraphType graph;
	int noVertex;
	
	// �����ڸ� �ۼ��Ͻÿ�.
	public Graph(int noVertex) {
		graph = new GraphType();
		this.noVertex = noVertex;
	}
		
	public void createGraph() {
		for (int i = 0; i < graph.noVertex; i++) {
			graph.visited[i] = false;
			graph.adjList[i] = null;
		}
	}
	
	class GraphType {
		int noVertex;
		GraphNode adjList[];
		boolean visited[];
		
		public GraphType() {
			adjList = new GraphNode[noVertex];
			visited = new boolean[noVertex];
		}
	}
	
	class GraphNode {
		int vertex;
		GraphNode link;
	}
	
	class StackNode {
		int data;
		StackNode link;
		
		public StackNode(int data) {
			this.data = data;
		}
	}
	
	class Stack {
		StackNode top;
		
		public void push(int data) {
			StackNode tmp = new StackNode(data);
			tmp.link = top;
			top = tmp;
		}
		
		public int pop() {
			int data;
			StackNode tmp = top;
			
			if (top == null) {
				System.out.println("Stack is Empty.");
				return 0;
			} else {
				data = tmp.data;
				top = tmp.link;
				tmp = null;
				return data;
			}
		}
	}
	
	// ���� (i, j)�� �����Ѵ�.
	public void addEdge(int i, int j) {
		GraphNode node;
		
		node = new GraphNode();
		node.vertex = i;
		node.link = graph.adjList[j];
		graph.adjList[i] = node;
	}
	
	// ���� (i, j)�� �����Ѵ�.
	public void removeEdge(int i, int j) {
		
	}
	
	// BFS�� Ž���ϸ鼭 �湮�ϴ� ��带 ����Ѵ�.
	public void bfs(int v) {
		
	}
	
	// DFS�� Ž���ϸ鼭 �湮�ϴ� ��带 ����Ѵ�.
	public void dfs(int v) {
		GraphNode tmp;
		Stack stack = new Stack();
		stack.top = null;
		stack.push(v);
		
		graph.visited[v] = true;
		System.out.print(" " + (char)(v + 65));
		
		while (stack.top != null) {
			tmp = graph.adjList[v];
			
			while (tmp != null) {
				if (!graph.visited[tmp.vertex]) {
					stack.push(tmp.vertex);
					graph.visited[tmp.vertex] = true;
					System.out.print(" " + (char)(tmp.vertex + 65));
					v = tmp.vertex;
					tmp = graph.adjList[v];
				} else
					tmp = tmp.link;
			}
			v = stack.pop();
		}
	}
	
	// �׷����� ����ϴ� �޼ҵ��̴�.
	public void print() {
		
	}
		
}
