import java.util.Scanner;

public class SeasonSwitch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("월을 입력하세요(1~12)>>");
		int month = scanner.nextInt();
		switch(month) {
			case 3: 
			case 4: 
			case 5:
				System.out.println("따뜻한 봄");
				break;
			case 6: 
			case 7: 
			case 8:
				System.out.println("바다가 즐거운 여름");
				break;
			case 9: 
			case 10: 
			case 11:
				System.out.println("낙엽이 지는 아름다운 가을");
				break;
			case 12 : case 1: case 2: // 옆으로 나란히 쓰도 됨
				System.out.println("눈 내리는 하얀 겨울");
				break;
			default:
				System.out.println("잘못입력");
		}
		scanner.close();
	}
}
