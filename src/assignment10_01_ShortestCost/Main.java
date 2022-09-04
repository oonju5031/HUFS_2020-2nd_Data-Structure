package assignment10_01_ShortestCost;

import java.util.Scanner;

public class Main {
	
	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		Graph g = new Graph();	// 그래프 생성
		g.loadData(scan);	// 그래프 데이터 읽음
		
		int startVertex = scan.nextInt();	// 출발 정점 
		
		int[] dist = g.shortestPath(startVertex); // 최단 경로에 따른 비용을 구함
		for(int i = 0; i < dist.length; i++)
			System.out.print(dist[i] + " ");	// 비용 출력
	}
}