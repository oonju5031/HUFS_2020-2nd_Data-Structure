package assignment03_02_SparseMatrix;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int col = scan.nextInt();
		int row = scan.nextInt();
		int no = scan.nextInt();
		
		SparseMatrix matrix = new SparseMatrix(row, col, no);
		
		for (int i = 1; i <= no; i++) {
			matrix.m[i][0] = scan.nextInt();
			matrix.m[i][1] = scan.nextInt();
			matrix.m[i][2] = scan.nextInt();
		}
		
		matrix.transpose();
		
		System.out.print(matrix);
		
		scan.close();
	}

}
