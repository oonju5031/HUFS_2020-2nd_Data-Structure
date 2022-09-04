package assignment03_02_SparseMatrix;

public class SparseMatrix {
	int[][] m;
	int[][] ts;
	
	/**
	 * @param row 행의 개수
	 * @param col 열의 개수
	 * @param no 0이 아닌 항의 개수
	 */
	public SparseMatrix(int row, int col, int no) {
		m = new int[no + 1][3];
		m[0][0] = row;
		m[0][1] = col;
		m[0][2] = no;
	}
	
	public void transpose() {
		int no = m[0][2];
		ts = new int[no + 1][3];
		ts[0][0] = m[0][0];
		ts[0][1] = m[0][1];
		ts[0][2] = no;
		
		int k = 1;
		for (int p = 0; p < m[0][0]; p++) {
			for (int i = 1; i <= no; i++) {
				if (m[i][1] == p) {
					ts[k][0] = m[i][1];
					ts[k][1] = m[i][0];
					ts[k][2] = m[i][2];
					k++;
				}
			}
		}
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		for (int i = 0; i <= ts[0][2]; i++) {
			str.append(ts[i][0]).append(" ")
				.append(ts[i][1]).append(" ")
				.append(ts[i][2]).append("\n");
		}
		
		return str.toString();
	}

}