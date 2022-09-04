package assignment03_01_Polynomial_02;

public class Polynomial {
	private int[][] term;
	
	public Polynomial(int noTerm) {
		term = new int[noTerm][2];
	}
	
	public Polynomial() {
		this(20);
	}
	
	public void addTerm(int coef, int exp) {
		term[exp][0] = coef;
		term[exp][1] = exp;
	}
	
	public String toString() {
		String pol = new String();
		
		for (int i = 0; i < term.length; i++) {
			if ((term[i][0] != 0) && (term[i][0] != 1) && (term[i][1] > 1))
				pol = term[i][0] + "x^" + term[i][1] + "+" + pol;
			else if ((term[i][0] != 0) && (term[i][0] == 1) && (term[i][1] > 1))
				pol = "x^" + term[i][1] + "+" + pol;
			else if ((term[i][0] != 0) && (term[i][0] != 1) && (term[i][1] == 1))
				pol = term[i][0] + "x" + "+" + pol;
			else if ((term[i][0] != 0) && (term[i][0] == 1) && (term[i][1] == 1))
				pol =  "x" +  "+" + pol;
			else if ((term[i][0] != 0) && (term[i][0] != 1) && (term[i][1] == 0))
				pol = term[i][0] + "+" + pol;
		}
		
		try {
			pol = pol.substring(0, pol.length() - 1);
		} catch (Exception e) {
			pol = "0";
		}
		return pol;
	}
	
	public static Polynomial polyAdd(Polynomial p1, Polynomial p2) {
		Polynomial p3 = new Polynomial();
		
		for (int i = 0; i < p3.term.length; i++) {
			p3.term[i][0] = p1.term[i][0] + p2.term[i][0];
			p3.term[i][1] = i;
		}
		
		return p3;
	}

}
