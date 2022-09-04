package assignment04_03_DeepCopy_00;

public class GenList implements Cloneable {
	private class ListNode {
		private Object data;
		private ListNode link;
		
		public ListNode() {
			data = null;
			link = null;
		}
		
		// �ۼ��ؾ� �� (deep copy)
		public Object clone() {
			
			return null;
		}
		
		// �������� ���ÿ�.
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
		 * ���� ojb instanceof GenList ���·� �˻��ϳ�
		 * �� ��� obj�� GenList�� ���� Ŭ������ ��쿡��
		 * ��ġ�ϴ� ������ �����Ǳ� ������
		 * �� Ŭ������ ��Ȯ�� ��ġ�ϴ��� �˻��ϴ� ����� ����Ѵ�.
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
