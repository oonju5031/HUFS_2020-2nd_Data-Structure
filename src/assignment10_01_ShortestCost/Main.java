package assignment10_01_ShortestCost;

import java.util.Scanner;

public class Main {
	
	// main �޼ҵ�� �������� ���ÿ�.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		Graph g = new Graph();	// �׷��� ����
		g.loadData(scan);	// �׷��� ������ ����
		
		int startVertex = scan.nextInt();	// ��� ���� 
		
		int[] dist = g.shortestPath(startVertex); // �ִ� ��ο� ���� ����� ����
		for(int i = 0; i < dist.length; i++)
			System.out.print(dist[i] + " ");	// ��� ���
	}
}