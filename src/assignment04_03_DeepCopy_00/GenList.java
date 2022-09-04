package assignment04_03_DeepCopy_00;

public class GenList implements Cloneable {
	private class ListNode {
		private Object data;
		private ListNode link;
		
		public ListNode() {
			data = null;
			link = null;
		}
		
		// 작성해야 함 (deep copy)
		public Object clone() {
			
			return null;
		}
		
		// 수정하지 마시오.
		public boolean equals(Object obj) {
			if (this == obj) {
				throw new NoDeepCopiedObjectException();
			}
			
			if (!(obj instanceof ListNode))
				return false;
			
			ListNode node = (ListNode)obj;
			
			boolean b = false;
			if (data == null && node.data == null)
				b = true;
			else if (data != null && node.data != null)
				b = data.equals(node.data);
			
			if (b) {
				if (link == null && node.link == null)
					b = true;
				else if (link != null && node.link != null)
					b = link.equals(node.link);
			}
			
			return b;
		}
	}
	
	private ListNode head;
	
	public void insertData(Object data) {
		ListNode newNode = new ListNode();
		newNode.data = data;
		newNode.link = head;
		head = newNode;
	}
	
	public void print() {
		System.out.print("(");
		for (ListNode p = head; p != null; p = p.link) {
			if (p.data instanceof GenList)
				((GenList)p.data).print();
			else
				System.out.print(p.data);
				
			if (p.link != null)
				System.out.print(", ");
		}
		System.out.print(")");
	}
	
	@Override
	public boolean equals(Object obj) {
		/*
		 * 보통 ojb instanceof GenList 형태로 검사하나
		 * 이 경우 obj가 GenList의 하위 클래스인 경우에도
		 * 일치하는 것으로 판정되기 때문에
		 * 두 클래스가 정확히 일치하는지 검사하는 방법을 사용한다.
		 */
		if (this.getClass() != obj.getClass())
			return false;
		
		return head.equals(((GenList)obj).head);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		GenList list = new GenList();
		list.head = (ListNode)head.clone();
		return list;
	}
}
