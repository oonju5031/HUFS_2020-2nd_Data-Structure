package assignment08_02_heap;

public class MaxHeap {
	
	private int size = 0;	// MaxHeap에 저장된 데이터 갯수. p.336에서는 변수 n으로 표현
	private int[] heap; // MaxHeap
	
	/**
	 * @param capacity 힙 배열의 크기
	 */
	public MaxHeap(int capacity) {
		heap = new int[capacity];
		heap[0] = 65535;
	}
	
	public void print() {
		for(int i = 1; i <= size; i++)
			System.out.print(heap[i] + " ");
	}
	
	// 아래 2개의 메소드(insert, delete)를 작성하시오.
	
	/**
	 * 교재 p.336 참조
	 * @param item 삭입하고자 하는 데이터
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
	 * 교재 p.338 참조
	 * MaxHeap에서 최대값을 삭제하고 그 같은 반환한다.
	 * @return 최대값 출력
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