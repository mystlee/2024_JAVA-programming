import java.util.Scanner;

abstract class Box {
	protected int size; // 현재 박스에 들어 있는 재료의 양
	public Box(int size) { // 생성자
		this.size = size;
	}
	public boolean isEmpty() { return size == 0; } // 박스가 빈 경우 true 리턴
	public abstract boolean consume(); // 박스에 들어 있는 재료를 일정량 소비
	public abstract void print(); // 박스에 들어 있는 량을 “*”문자로 출력
}

class IngredientBox  extends Box {
	private String name;
	public IngredientBox(String name, int size) {
		super(size);
		this.name = name;
	}
	
	@Override
	public void print() {
		System.out.print(name + ' ');
		for(int i=0; i<size; i++) 
			System.out.print("*");
		System.out.println(size);
	}

	@Override
	public boolean consume() {
		if(size == 0)
			return false;
		size --;
		return true;
	}
}

class CoffeeVendingMachine {
	private String name;
	private IngredientBox coffee = new IngredientBox("커피", 5);
	private IngredientBox cream = new IngredientBox("프림", 5);		
	private IngredientBox sugar = new IngredientBox("설탕", 5);
	private Scanner scanner = new Scanner(System.in);
	
	public CoffeeVendingMachine(String name) {
		this.name = name;
	}
	
	private int getMenu() {
		System.out.print("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>");
		int menu = scanner.nextInt();
		return menu;
	}
	
	private void print() {
		coffee.print();
		cream.print();
		sugar.print();
	}
	
	public void run() {
		System.out.println("*****" + name + "입니다.*****");
		print();
		while(true) {
			int menu = getMenu();
			switch(menu) {
				case 1 : // 다방커피
					if(coffee.isEmpty() || cream.isEmpty() || sugar.isEmpty()) {
						System.out.println("원료가 부족합니다."); break;
					}
					coffee.consume(); cream.consume(); sugar.consume(); break;
				case 2 : // 설탕 커피
					if(coffee.isEmpty() || sugar.isEmpty()) {
						System.out.println("원료가 부족합니다."); break;
					}					
					coffee.consume(); sugar.consume(); break;		
				case 3 : // 블랙 커피
					if(coffee.isEmpty()) {
						System.out.println("원료가 부족합니다."); break;
					}
					coffee.consume(); break;
				case 4 : // 종료 메뉴
					System.out.println(name + " 프로그램을 종료합니다"); 
					return;						
				default:
					System.out.println("다시 입력하세요!"); 
					continue;
			}
			print();

		}		
	}
	
}

public class VendingMachineEx {

	public static void main(String[] args) {
		new CoffeeVendingMachine("청춘 커피 자판기").run();
	}

}
