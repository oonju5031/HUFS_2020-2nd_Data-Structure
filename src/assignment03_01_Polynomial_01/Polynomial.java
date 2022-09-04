package assignment03_01_Polynomial_01;

public class Polynomial {
	private int[][] term;
	private int curNoTerm = 0;
	
	// @param noTerm 항의 개수
	public Polynomial(int noTerm) {
		term = new int[noTerm][2];
	}
	
	public Polynomial() {
		this(20);  // default로 최대 20개의 항을 저장함
	}
	
	/**
	 * @param exp 지수
	 * @return coef 해당 지수항의 계수
	 */
	public int coef(int exp) {
		for (int i = 0; i < term.length; i++) {
			if (term[i][1] == exp)
				return term[i][0];
		}
		return 0;
	}
	
	/**
	 * @param coef 계수
	 * @param exp 지수
	 */
	public void addTerm(int coef, int exp) {
		term[curNoTerm][0] = coef;
		term[curNoTerm][1] = exp;
		curNoTerm++;
		
		// debug
		for (int i = 0; i < term.length; i++) {
			for (int j = 0; j < term[i].length; j++)
				System.out.print(term[i][j] + " ");
			System.out.print(" ");
		}
		
	}
	
	/**
	 * 입력받은 지수항의 계수를 0으로 만든다.
	 * @param exp
	 */
	public void delTerm(int exp) {
		for (int i = 0; i < term.length; i++) {
			if (term[i][1] == exp) {
				term[i][0] = 0;
				term[i][1] = 0;
			}
		}
	}
	
	public boolean isZeroP() {
		for (int i = 0; i < term.length; i++) {
			if (term[i][0] != 0)
				return false;
		}
		return true;
	}
	
	public int maxExp() {
		int max = 0;
		for (int i = 0; i < term.length; i++) {
			if (max < term[i][1])
				max = term[i][1];
		}
		return max;
	}
	
	/**
	 * 출력할 때 사용
	 * @return 객체를 문자열로 반환 (예: 3x^15 + 2x^3 + 4x^2 + x + 5)
	 */
	public String toString() {
		String pol = new String();
		
		for (int i = 0; i < term.length - 1; i++) {
			if ((term[i][0] != 0) && (term[i][1] != 1)) {
				pol = pol + term[i][0] + "x^" + term[i][1];
			} else if (term[i][0] == 1) {
				pol = pol + "x^" + term[i][1];
			}
		}
		
		return pol;
	}
	
	/**
	 * 두 개의 다항식을 더한다.
	 * @param p1 첫 번째 다항식
	 * @param p2 두 번째 다항식
	 * @return 두 개의 다항식을 더한 결과
	 */
	public static Polynomial polyAdd(Polynomial p1, Polynomial p2) {
		Polynomial p3 = new Polynomial();
		
		while (!p1.isZeroP() && !p2.isZeroP()) {
			if (p1.maxExp() < p2.maxExp()) {
				p3.addTerm(p2.coef(p2.maxExp()), p2.maxExp());
				p2.delTerm(p2.maxExp());
			} else if (p1.maxExp() == p2.maxExp()) {
				int sum = p1.coef(p1.maxExp()) + p1.coef(p2.maxExp());
				if (sum != 0)
					p3.addTerm(sum,  p1.maxExp());
				p1.delTerm(p1.maxExp());
				p2.delTerm(p2.maxExp());
			} else {
				p3.addTerm(p1.coef(p1.maxExp()), p1.maxExp());
				p1.delTerm(p1.maxExp());
			}
		}
		while (!p1.isZeroP()) {
			p3.addTerm(p1.coef(p1.maxExp()), p1.maxExp());
			p1.delTerm(p1.maxExp());
		}
		while (!p2.isZeroP()) {
			p3.addTerm(p2.coef(p2.maxExp()), p2.maxExp());
			p2.delTerm(p2.maxExp());
		}
		
		return p3;
	}

}
