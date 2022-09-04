package assignment08_03_DeleteBinaryTree;

public class BinarySearchTree {
	class TreeNode {
		String key;
		TreeNode left;
		TreeNode right;
	}
	
	private TreeNode rootNode;
	
	public void insert(String x) {
		rootNode = insertKey(rootNode, x);
	}
	
	public void delete(String x) {
		if (rootNode != null)
			rootNode = delete(rootNode, x);
	}
	
	public TreeNode find(String x) {
		TreeNode t = rootNode;
		int result;
		
		while (t != null) {
			if ((result = x.compareTo(t.key)) < 0) {
				t = t.left;
			} else if (result == 0) {
				return t;
			} else {
				t = t.right;
			}
		}
		
		return t;
	}
	
	private void printNode(TreeNode n) {
		if (n != null) {
			System.out.print("(");
			printNode(n.left);
			System.out.print(n.key);
			printNode(n.right);
			System.out.print(")");
		}
	}
	
	public void print() {
		printNode(rootNode);
		System.out.println();
	}
	
	// �Ʒ� 2���� �޼ҵ� insertKey, delete�� �ϼ��Ͻÿ�.
	
	/**
	 * ���� p.325 ����
	 * �̿�Ž��Ʈ���� ��� t�� ������ x�� �߰��Ѵ�. ��ȯ�Լ��� �ۼ��ؾ� �Ѵ�.
	 * @param t �̿�Ž��Ʈ���� ���. �� ��� �Ʒ��� �����͸� �����Ѵ�.
	 * @param x �����ϰ��� �ϴ� ������
	 * @return ������ �̿�Ž��Ʈ���� �θ� ���
	 */
	private TreeNode insertKey(TreeNode t, String x) {
		if (t == null) {  // BinaryTree �ʱ갪 ����
			TreeNode newNode = new TreeNode();
			newNode.key = x;
			return newNode;
		} else if (x.compareTo(t.key) < 0) {
			t.left = insertKey(t.left, x);
			return t;
		} else if (x.compareTo(t.key) > 0) {
			t.right = insertKey(t.right, x);
			return t;
		} else  // key���� �̹� BinaryTree�� �ִ� ���
			return t;
	}

	/**
	 * ���� p.324 ����
	 * ���� Ʈ������ x �� ã�Ƽ� �� ��带 �����Ѵ�.
	 * @param x �����ϰ��� �ϴ� ������
	 */
	public TreeNode delete(TreeNode node, String x) {
		if (node == null)
			return node;
		
		if (x.compareTo(node.key) < 0)
			node.left = delete(node.left, x);
		else if (x.compareTo(node.key) > 0)
			node.right = delete(node.right, x);
		else {
			if (node.left == null && node.right == null) {
				return null;
			}
			if (node.left == null) {
				TreeNode temp = node.right;
				node = null;
				return temp;
			} else if (node.right == null) {
				TreeNode temp = node.left;
				node = null;
				return temp;
			}
			
			TreeNode temp = getPredecessor(node.left);
			node.key = temp.key;
			node.left = delete(node.left, temp.key);
		}
		
		return node;
	}
	
	private TreeNode getPredecessor(TreeNode node) {
		if (node.right != null)
			return getPredecessor(node.right);
		return node;
	}
}