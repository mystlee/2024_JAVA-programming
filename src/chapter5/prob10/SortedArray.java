import java.util.Scanner;

class SortedArray extends BaseArray {
	public SortedArray(int size) {
		super(size);
	}
	
	@Override
	public void add(int n) {
		int i=0;
		for(i=0; i<nextIndex; i++) {
			if(n < array[i]) { // 삽입되는 n이 배열[i] 값보다 작은 경우, 삽입될 위치는 i 
				break;
			}
		}
		insert(n, i); // i번째부터 nextIndex까지는 뒤로 이동, 배열의 i 위치에 정수 n 삽입 
		nextIndex++;
	}
	
	// i번째부터 nextIndex까지는 뒤로 밀고, 배열의 i 위치에 정수 n 삽입 
	private void insert(int n, int i) {
		for(int j=nextIndex; j>i; j--) { // i위치부터 nextIndex 앞까지 뒤로 이동
			array[j] = array[j-1];
		}
		array[i] = n;
	}
	
	public static void main(String [] args) {
		SortedArray sArray = new SortedArray(10);
		Scanner scanner = new Scanner(System.in);

		System.out.print(">>");
		for(int i=0; i<sArray.length(); i++) {
			int n = scanner.nextInt();
			sArray.add(n);
		}
		sArray.print();
		scanner.close();
	}
}