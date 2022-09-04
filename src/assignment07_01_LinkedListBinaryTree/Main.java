package assignment07_01_LinkedListBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	// �Ʒ� 4���� �޼ҵ带 �ۼ��Ͻÿ�.
	
	public static void inorder(BinaryTree node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}
	
	public static void preorder(BinaryTree node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	public static void postorder(BinaryTree node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + " ");
		}
	}
	
	public static void levelorder(BinaryTree node) {
		Queue<BinaryTree> queue = new LinkedList<>();
		queue.offer(node);
		
		while (!queue.isEmpty()) {
			BinaryTree now = queue.poll();
			System.out.print(now.data + " ");
			if (now != null) {
				if (now.left != null)
					queue.offer(now.left);
				if (now.right != null)
					queue.offer(now.right);
			}
		}
	}
	
	// �Ʒ��� main �޼ҵ�� �������� ���ÿ�.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		
		BinaryTree root = null;
		
		// ���� Ʈ�� ����
		while (scan.hasNext()) {
			String token = scan.next();
			if (token.equals("null")) {
				stack.push(null);
			} else if (token.equals(")")) {
				BinaryTree right = stack.pop();
				if (stack.isEmpty()) {
					root = right;
					break;
				}
				BinaryTree left = stack.pop();
				root = stack.pop();
				root.setChildren(left, right);
				stack.push(root);
			} else if (token.equals("(")) {
				continue;
			} else {
				stack.push(new BinaryTree(token));
			}
		}
		
		scan.close();
		
		inorder(root);
		System.out.println();
		preorder(root);
		System.out.println();
		postorder(root);
		System.out.println();
		levelorder(root);
	}

}
