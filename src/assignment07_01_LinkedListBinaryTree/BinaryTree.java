package assignment07_01_LinkedListBinaryTree;

public class BinaryTree {
	String data;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(String data) {
		this.data = data;
		left = right = null;
	}
	
	public void setChildren(BinaryTree left, BinaryTree right) {
		this.left = left;
		this.right = right;
	}

}
