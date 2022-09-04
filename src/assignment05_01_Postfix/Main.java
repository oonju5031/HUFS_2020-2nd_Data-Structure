package assignment05_01_Postfix;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	// 필요한 필드 또는 메소드를 작성하시오.
	static Stack<Double> stack = new Stack<Double>();
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		// 아래 코드를 완성하시오.
		String str = scan.next();
		while (!str.equals("$")) {
			if (str.equals("+")) {
				double a = stack.pop();
				double b = stack.pop();
				double result = (a + b);
				stack.push(result);
				
			} else if (str.equals("-")) {
				double a = stack.pop();
				double b = stack.pop();
				double result = (b - a);
				stack.push(result);
				
			} else if (str.equals("*")) {
				double a = stack.pop();
				double b = stack.pop();
				double result = (a * b);
				stack.push(result);
				
			} else if (str.equals("/")) {
				double a = stack.pop();
				double b = stack.pop();
				double result = (b / a);
				stack.push(result);
				
			} else {
				double operand = Double.parseDouble(str);
				stack.push(operand);
				
			}
			str = scan.next();
		}
		scan.close();
		
		System.out.println(stack.pop());
	}

}
