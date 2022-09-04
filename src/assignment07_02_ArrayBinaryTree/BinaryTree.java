package assignment07_02_ArrayBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	String[] array;
	public static final int INIT_SIZE = 50;
	public static final int ROOT = 1;
    
	public BinaryTree() {
		array = new String[INIT_SIZE];
	}
	
	public void set(int index, String data) {
		if (index >= array.length) {
			String[] newArray = new String[index + 10];
			for(int i = 0; i < array.length; i++)
				newArray[i] = array[i];
			array = newArray;
		}
		array[index] = data;
	}
	
	// 배열에서 원소를 얻는 메소드
	public String get(int index) {
		if (index >= array.length)
			return null;
		
		return array[index];
	}
	
	public void inorder() {
		inorder(array, ROOT);
	}
	
	public void preorder() {
		preorder(array, ROOT);
	}
	
	public void postorder() {
		postorder(array, ROOT);
	}
	
	public void levelorder() {
		levelorder(array, ROOT);
	}
	
	/*************************************
	 * 작성해야 하는 함수
	 *************************************/

	private void inorder(String[] tree, int idx) {
		if (tree[idx] != null) {
			inorder(tree, idx * 2);
			System.out.print(tree[idx] + " ");
			inorder(tree, idx * 2 + 1);
		}
		
	}
	
	private void preorder(String[] tree, int idx) {
		if (tree[idx] != null) {
			System.out.print(tree[idx] + " ");
			preorder(tree, idx * 2);
			preorder(tree, idx * 2 + 1);
		}
	}
	
	private void postorder(String[] tree, int idx) {
		if (tree[idx] != null) {
			postorder(tree, idx * 2);
			postorder(tree, idx * 2 + 1);
			System.out.print(tree[idx] + " ");
		}
	}
	
	private void levelorder(String[] tree, int idx) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(idx);
		
		while (!queue.isEmpty()) {
			Integer now = queue.poll();
			System.out.print(tree[now] + " ");
			
			if (tree[now * 2] != null)
				queue.offer(now * 2);
			if (tree[now * 2 + 1] != null)
			queue.offer(now * 2 + 1);
		}
	}
}