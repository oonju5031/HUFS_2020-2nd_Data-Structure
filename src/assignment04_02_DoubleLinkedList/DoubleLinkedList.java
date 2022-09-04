package assignment04_02_DoubleLinkedList;

public class DoubleLinkedList {
	private ListNode head;  // 리스트의 첫 번째 노드를 가리킴
	private ListNode tail;  // 리스트의 마지막 노드를 가리킴
	
	public DoubleLinkedList() {
		head = tail = null;  // 리스트가 비어있을 때는 모두 null이다.
	}
	
	/**
	 * @param str 삽입하고자 하는 데이터
	 */
	public void insert(String str) {
		ListNode node = new ListNode();  // 삽입할 노드
		node.data = str;
		
		if (str == null)
			throw new NullPointerException();
		
		if (head == null) {  // DoubleLinkedList가 비어 있는 경우
			head = node;
			tail = node;
		} else {
			for (ListNode search = head; search != null; search = search.rlink) {
				if (node.data.compareTo(search.data) < 0) {
					if (search.llink == null) {  // search가 head인 경우
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
			if (node.data.compareTo(tail.data) > 0) {  // node가 tail이 됨
				node.llink = tail;
				node.rlink = null;
				tail.rlink = node;
				tail = node;
			}
		}
	}
	
	/**
	 * @param str 삭제하고자 하는 데이터
	 */
	public void delete(String str) {
		
		// data값이 str인 ListNode node를 찾는다.
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
		
		// node를 제거한다.
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
	
	// 저장된 모든 데이터를 출력한다.
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
