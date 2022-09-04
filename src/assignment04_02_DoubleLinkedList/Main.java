package assignment04_02_DoubleLinkedList;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		DoubleLinkedList list = new DoubleLinkedList();
		
		while (true) {
			String cmd = scan.next();
			if (cmd.equals("E"))
				break;
			
			if (cmd.equals("I"))
				list.insert(scan.next());
			else if (cmd.equals("D"))
				list.delete(scan.next());
			else if (cmd.equals("P"))
				list.print();
			else
				System.out.println("ERROR");
		}
		
		scan.close();
	}
}
