package assignment04_01_Polynomial;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		// ù ��° ���׽� �Է�
		Polynomial p1 = new Polynomial();
		int no = scan.nextInt();
		for (int i = 0; i < no; i++) {
			int coef = scan.nextInt();
			int exp = scan.nextInt();
			p1.addTerm(coef, exp);
		}
		
		// �� ��° ���׽� �Է�
		Polynomial p2 = new Polynomial();
		int no2 = scan.nextInt();
		for (int i = 0; i < no2; i++) {
			int coef2 = scan.nextInt();
			int exp2 = scan.nextInt();
			p2.addTerm(coef2, exp2);
		}
		
		// �� ���� ���׽� ����
		Polynomial p3 = Polynomial.polyAdd(p1, p2);
		
		System.out.print(p3);  // System.out.print(p3.toString())�� ����
		
		scan.close();
	}

}
