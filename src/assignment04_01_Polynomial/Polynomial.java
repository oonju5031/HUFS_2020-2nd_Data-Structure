package assignment04_01_Polynomial;

public class Polynomial {
	
	/**
	 * 클래스 내부에 클래스를 만드는 경우를 예로 든 것이다.
	 * 이렇게 할 경우 클래스 Term은 Polynomial 클래스 내에서만
	 * 의미가 있다는 것을 알 수 있다.
	 */
	class Term {
		int coef;
		int exp;
		Term link;
	}
	
	private Term head;  // 첫 번째 항을 가리키는 레퍼런스 변수
	private Term tail;  // 마지막 항을 가리키는 레퍼런스 변수
	
	public Polynomial() {
		head = tail = null;  // 원래 객체의 인스턴스 필드는 null로 초기화되지만 이해를 위해 별도로 명시함
	}
	
	/**
	 * @param coef 계수
	 * @param exp 지수
	 */
	public void addTerm(int coef, int exp) {
		Term term = new Term();
		term.coef = coef;
		term.exp = exp;
		term.link = null;
		
		if (head == null) {  // 처음으로 항이 추가되는 경우
			head = tail = term;
		} else {
			tail.link = term;
			tail = term;  // 마지막을 가리키는 항을 재지정
		}
	}
	
	/**
	 * 출력할 때 사용
	 * @return 객체를 문자열로 반환
	 * (예: 3x^15+2x^3+4x^2+x+5)
	 */
	public String toString() {
		if (head == tail)  // 항이 없으면 0을 반환한다.
			return "0";
		
		String poly = new String();
		Term now = head;
		
		while (now.link != null) {
			if (now.coef < 0)  // 계수가 음수인 경우
				poly += now.coef + "x^" + now.exp;
			else if (now.coef == 1)  // 계수가 1인 경우
				poly += "+" + "x^" + now.exp;
			else  // 계수가 1이 아닌 양수인 경우
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
		
		if (poly.charAt(0) == '+')  // 문자열 제일 앞의 '+' 제거
			poly = poly.substring(1, poly.length());
		if ((poly.substring(poly.length() - 4)).equals("+x^0"))  // 1x^0을 1로 변환
			poly = poly.replace("+x^0", "1");
		if ((poly.substring(poly.length() - 3)).equals("x^0"))  // nx^0을 n으로 변환
			poly = poly.substring(0, poly.length() - 3);
		
		return poly;
	}
	
	/**
	 * 두 개의 다항식을 더한다.
	 * @param p1 첫 번째 다항식
	 * @param p2 두 번째 다항식
	 * @return 두 개의 다항식을 더한 결과
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
