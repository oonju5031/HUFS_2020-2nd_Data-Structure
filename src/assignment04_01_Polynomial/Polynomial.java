package assignment04_01_Polynomial;

public class Polynomial {
	
	/**
	 * Ŭ���� ���ο� Ŭ������ ����� ��츦 ���� �� ���̴�.
	 * �̷��� �� ��� Ŭ���� Term�� Polynomial Ŭ���� ��������
	 * �ǹ̰� �ִٴ� ���� �� �� �ִ�.
	 */
	class Term {
		int coef;
		int exp;
		Term link;
	}
	
	private Term head;  // ù ��° ���� ����Ű�� ���۷��� ����
	private Term tail;  // ������ ���� ����Ű�� ���۷��� ����
	
	public Polynomial() {
		head = tail = null;  // ���� ��ü�� �ν��Ͻ� �ʵ�� null�� �ʱ�ȭ������ ���ظ� ���� ������ �����
	}
	
	/**
	 * @param coef ���
	 * @param exp ����
	 */
	public void addTerm(int coef, int exp) {
		Term term = new Term();
		term.coef = coef;
		term.exp = exp;
		term.link = null;
		
		if (head == null) {  // ó������ ���� �߰��Ǵ� ���
			head = tail = term;
		} else {
			tail.link = term;
			tail = term;  // �������� ����Ű�� ���� ������
		}
	}
	
	/**
	 * ����� �� ���
	 * @return ��ü�� ���ڿ��� ��ȯ
	 * (��: 3x^15+2x^3+4x^2+x+5)
	 */
	public String toString() {
		if (head == tail)  // ���� ������ 0�� ��ȯ�Ѵ�.
			return "0";
		
		String poly = new String();
		Term now = head;
		
		while (now.link != null) {
			if (now.coef < 0)  // ����� ������ ���
				poly += now.coef + "x^" + now.exp;
			else if (now.coef == 1)  // ����� 1�� ���
				poly += "+" + "x^" + now.exp;
			else  // ����� 1�� �ƴ� ����� ���
				poly += "+" + now.coef + "x^" + now.exp;
			
			now = now.link;
		}
		
		if (now.coef < 0)
			poly += now.coef + "x^" + now.exp;
		else if (now.coef == 1)
			poly += "+" + "x^" + now.exp;
		else
			poly += "+" + now.coef + "x^" + now.exp;
		
		poly = poly.replace("x^1+", "x+");
		
		if (poly.charAt(0) == '+')  // ���ڿ� ���� ���� '+' ����
			poly = poly.substring(1, poly.length());
		if ((poly.substring(poly.length() - 4)).equals("+x^0"))  // 1x^0�� 1�� ��ȯ
			poly = poly.replace("+x^0", "1");
		if ((poly.substring(poly.length() - 3)).equals("x^0"))  // nx^0�� n���� ��ȯ
			poly = poly.substring(0, poly.length() - 3);
		
		return poly;
	}
	
	/**
	 * �� ���� ���׽��� ���Ѵ�.
	 * @param p1 ù ��° ���׽�
	 * @param p2 �� ��° ���׽�
	 * @return �� ���� ���׽��� ���� ���
	 */
	public static Polynomial polyAdd(Polynomial p1, Polynomial p2) {
		Term a = p1.head;
		Term b = p2.head;
		Polynomial c = new Polynomial();
		
		while ((a != null) && (b != null)) {
			if (a.exp == b.exp) {
				int sum = a.coef + b.coef;
				if (sum != 0)
					c.addTerm(sum, a.exp);
				a = a.link;
				b = b.link;
			} else if (a.exp < b.exp) {
				c.addTerm(b.coef, b.exp);
				b = b.link;
			} else {
				c.addTerm(a.coef, a.exp);
				a = a.link;
			}
		}
		
		while (a != null) {
			c.addTerm(a.coef, a.exp);
			a = a.link;
		}
		while (b != null) {
			c.addTerm(b.coef, b.exp);
			b = b.link;
		}
		
		return c;
	}

}
