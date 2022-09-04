package assignment04_03_DeepCopy_00;

public class Main {
	// main �޼ҵ�� �������� ���ÿ�.
	public static void main(String[] args) throws Exception {
		GenList p = new GenList();
		
		p.insertData(new Integer(82));
		p.insertData("Korea");
		
		GenList q = new GenList();
		q.insertData(p);
		q.insertData("Seoul");
		
		GenList r = new GenList();
		r.insertData(q);
		r.insertData("Busan");
		
		GenList l = new GenList();
		l.insertData(r);
		l.insertData(q);
		l.insertData("City");
		
		// ������� �� �� print �Լ� �̿�
		// l.print();
		// System.out.println();
		
		GenList k = null;
		try {
			k = (GenList)(l.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println(l.equals(k));
	}

}
