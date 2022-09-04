package assignment04_02_DoubleLinkedList;

public class DoubleLinkedList {
	private ListNode head;  // ����Ʈ�� ù ��° ��带 ����Ŵ
	private ListNode tail;  // ����Ʈ�� ������ ��带 ����Ŵ
	
	public DoubleLinkedList() {
		head = tail = null;  // ����Ʈ�� ������� ���� ��� null�̴�.
	}
	
	/**
	 * @param str �����ϰ��� �ϴ� ������
	 */
	public void insert(String str) {
		ListNode node = new ListNode();  // ������ ���
		node.data = str;
		
		if (str == null)
			throw new NullPointerException();
		
		if (head == null) {  // DoubleLinkedList�� ��� �ִ� ���
			head = node;
			tail = node;
		} else {
			for (ListNode search = head; search != null; search = search.rlink) {
				if (node.data.compareTo(search.data) < 0) {
					if (search.llink == null) {  // search�� head�� ���
						node.rlink = head;
						node.llink = null;
						head.llink = node;
						head = node;
						break;
					} else {
						node.llink = search.llink;
						node.rlink = search;
						search.llink.rlink = node;
						search.llink = node;
						break;
					}
				}
			}
			if (node.data.compareTo(tail.data) > 0) {  // node�� tail�� ��
				node.llink = tail;
				node.rlink = null;
				tail.rlink = node;
				tail = node;
			}
		}
	}
	
	/**
	 * @param str �����ϰ��� �ϴ� ������
	 */
	public void delete(String str) {
		
		// data���� str�� ListNode node�� ã�´�.
		ListNode node = new ListNode();
		
		if (str == null)
			throw new NullPointerException();
		
		for (ListNode search = head; search != null; search = search.rlink) {
			if (search.data.equals(str)) {
				node = search;
				break;
			}
		}
		
		if (node.data == null)
			System.out.println("The data is not in the list.");
		
		// node�� �����Ѵ�.
		if (node.data != null) {
			if (node.llink != null)
				node.llink.rlink = node.rlink;
			else
				head = head.rlink;
			
			if (node.rlink != null)
				node.rlink.llink = node.llink;
			else
				tail = tail.llink;
		}
		
	}
	
	// ����� ��� �����͸� ����Ѵ�.
	public void print() {
		if (head == null) {
			System.out.println("EMPTY");
			return;
		} else {
			for (ListNode i = head; i != null; i = i.rlink)
				System.out.print(i.data + " ");
			System.out.println();
		}
	}

}
