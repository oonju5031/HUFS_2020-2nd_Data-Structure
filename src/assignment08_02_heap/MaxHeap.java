package assignment08_02_heap;

public class MaxHeap {
	
	private int size = 0;	// MaxHeap�� ����� ������ ����. p.336������ ���� n���� ǥ��
	private int[] heap; // MaxHeap
	
	/**
	 * @param capacity �� �迭�� ũ��
	 */
	public MaxHeap(int capacity) {
		heap = new int[capacity];
		heap[0] = 65535;
	}
	
	public void print() {
		for(int i = 1; i <= size; i++)
			System.out.print(heap[i] + " ");
	}
	
	// �Ʒ� 2���� �޼ҵ�(insert, delete)�� �ۼ��Ͻÿ�.
	
	/**
	 * ���� p.336 ����
	 * @param item �����ϰ��� �ϴ� ������
	 */
	public void insert(int item) {
		int i;
		size++;
		
		for (i = size; ;) {
			if (i == 1)
				break;
			if (item <= heap[i / 2])
				break;
			heap[i] = heap[i / 2];
			i = i / 2;
		}
		heap[i] = item;
	}

	/**
	 * ���� p.338 ����
	 * MaxHeap���� �ִ밪�� �����ϰ� �� ���� ��ȯ�Ѵ�.
	 * @return �ִ밪 ���
	 */
	public int delete() {
		int item = heap[1];
		int temp = heap[size];
		size--;
		
		int parent = 1;
		int child = 2;
		while (child <= size) {
			if (child < size)
				if (heap[child] < heap[child + 1])
					child = child + 1;
			if (temp >= heap[child])
				break;
			heap[parent] = heap[child];
			parent = child;
			child = child * 2;
		}
		heap[parent] = temp;
		return item;
	}
}