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
	
	// 아래 2개의 메소드 insertKey, delete를 완성하시오.
	
	/**
	 * 교재 p.325 참조
	 * 이원탐색트리의 노드 t에 데이터 x를 추가한다. 순환함수로 작성해야 한다.
	 * @param t 이원탐색트리의 노드. 이 노드 아래에 데이터를 삽입한다.
	 * @param x 삽입하고자 하는 데이터
	 * @return 사입한 이원탐색트리의 부모 노드
	 */
	private TreeNode insertKey(TreeNode t, String x) {
		if (t == null) {  // BinaryTree 초깃값 지정
			TreeNode newNode = new TreeNode();
			newNode.key = x;
			return newNode;
		} else if (x.compareTo(t.key) < 0) {
			t.left = insertKey(t.left, x);
			return t;
		} else if (x.compareTo(t.key) > 0) {
			t.right = insertKey(t.right, x);
			return t;
		} else  // key값이 이미 BinaryTree에 있는 경우
			return t;
	}

	/**
	 * 교재 p.324 참조
	 * 이진 트리에서 x 를 찾아서 그 노드를 삭제한다.
	 * @param x 삭제하고자 하는 데이터
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