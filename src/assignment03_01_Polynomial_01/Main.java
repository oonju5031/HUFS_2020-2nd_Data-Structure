package assignment03_01_Polynomial_01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		// 첫 번째 다항식 입력
		int no = scan.nextInt();
		Polynomial p1 = new Polynomial(no);
		for (int i = 0; i < no; i++) {
			int coef = scan.nextInt();
			int exp = scan.nextInt();
			System.out.print("\rp1: ");  // Debug
			p1.addTerm(coef, exp);
		}
		
		// 두 번째 다항식 입력
		int no2 = scan.nextInt();
		Polynomial p2 = new Polynomial(no2);
		for (int i = 0; i < no2; i++) {
			int coef2 = scan.nextInt();
			int exp2 = scan.nextInt();
			System.out.print("\rp2: ");  // Debug
			p2.addTerm(coef2, exp2);
		}
		
		//  두 개의 다항식 덧셈
		Polynomial p3 = Polynomial.polyAdd(p1, p2);
		
		System.out.println();
		System.out.print(p3);  // System.out.print(p3.toString())과 동일
		
		scan.close();
	}

}
