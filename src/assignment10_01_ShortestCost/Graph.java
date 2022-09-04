package assignment10_01_ShortestCost;

import java.util.Scanner;

public class Graph {
	int noVertex;	// ������ ����
	int[][] m;	// ���� ���
	public static final int NONE = 999; // ��� ����
	
	/**
	 * �׷��� �����͸� �о����.
	 */
	public void loadData(Scanner scan) {
		int noVertex = scan.nextInt();	// ������ ����

		this.noVertex = noVertex;
		m = new int[noVertex][noVertex];
		
		// ������ ���� �׷��� ����
		for(int i = 0; i < noVertex; i++)
			for(int j = 0; j < noVertex; j++)
				m[i][j] = scan.nextInt();	// ����ġ
	}
	
	// �ʿ��� �޼ҵ峪 �ʵ带 �߰��Ͻÿ�.
	
	
	
	
	/**
	 * ���� p.393 ����
	 * startVertex���� ����Ͽ� ��� ���������� �ּ� ����� ���Ѵ�.
	 * @param startVertex ����ϴ� ���� (p.384���� ���� 0�� �ش�)
	 * @return ����������� �ٸ� ��� ���������� �ּ� ��� (p.394�� ��������� �ش�)
	 */
	public int[] shortestPath(int startVertex) {
		int[] dist = new int[noVertex];
		for(int i = 0; i < dist.length; i++)
			dist[i] = m[startVertex][i];
		
		// �ڵ带 �ۼ��Ͻÿ�.
		
		
		return dist;
	}
}