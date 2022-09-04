package assignment05_02_InfixToPostfix;

import java.util.Scanner;
import java.util.Stack;


// 제출: test가 달린 줄을 전부 삭제하면 된다.
public class Main {
	
	// 필요한 필드나 메소드가 있으면 작성하시오.
	static Stack<String> stack = new Stack<String>();
	
	public static Integer priorityInStack(String str) {
		if (str.equals("+") || str.equals("-"))
			return 1;
		else if (str.equals("*") || str.equals("/"))
			return 2;
		else if (str.equals("^"))
			return 3;
		else if (str.equals("("))
			return 0;
		return 5;
	}
	
	public static Integer priorityInExpression(String str) {
		if (str.equals("+") || str.equals("-"))
			return 1;
		else if (str.equals("*") || str.equals("/"))
			return 2;
		else if (str.equals("^"))
			return 3;
		else if (str.equals("("))
			return 4;
		return 5;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		// 아래 코드를 작성하시오.
		String str = scan.next();
		
		while (!str.equals("$")) {
			if (str.equals("(")) {
				stack.push(str);
				System.out.print(" ( Push ");  // Test
				System.out.println(stack);  // test
			}
			else if (str.equals(")")) {
				while (!stack.peek().equals("(")) {
					System.out.print(stack.pop() + " ");
					System.out.print("StackPop1 ");  //Test
					System.out.println(stack);  // test
				}
				stack.pop();  // "("를 제거
			} else if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
				while (!stack.isEmpty() && priorityInStack(stack.peek()) >= priorityInExpression(str)) {
					System.out.print(stack.pop() + " ");
					System.out.print("OperatorPop ");  // Test
					System.out.println(stack);  // test
				}
				stack.push(str);
				System.out.print(" StrPush ");  // Test
				System.out.println(stack);  // test
			} else {
				System.out.print(str + " ");
				System.out.print(" OperandPrint ");  // Test
				System.out.println(stack);  // test
			}
			
			str = scan.next();
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
			System.out.print(" ");
		}
		
		scan.close();
	}
}
