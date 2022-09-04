package assignment08_02_heap;

import java.util.Scanner;

public class Main {
	
	// 아래 main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		MaxHeap heap = new MaxHeap(100);
		
		while (scan.hasNext()) {
			String command = scan.next();
			
			if (command.equals("I")) {
				int data = Integer.parseInt(scan.next());
				heap.insert(data);
			} else if (command.equals("D")) {
				heap.delete();
			} else if (command.equals("P")) {
				heap.print();
			} else if (command.equals("E")) {
				break;
			}
		}
		scan.close();
	}
	
}