import java.util.Scanner;

public class BirthdayCandle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("나이를 입력하세요>>");
		int age = scanner.nextInt();
		if(age <= 0) {
			System.out.println("나이는 양수로만 입력하세요.");
			scanner.close();
			return; // 프로그램 종료
		}
		
		int redCandle = age/10; // 빨간초 개수 계산
		age = age % 10; // 빨간초의 나이 빼기
		
		int blueCandle = age/5; // 파간초 개수 계산
		age = age % 5; // 파란초의 나이 빼기

		int yellowCandle = age; // 노란초 개수
		int totalCandle = redCandle + blueCandle + yellowCandle; // 전체 초 개수
		
		System.out.print("빨간 초 " + redCandle + "개, ");
		System.out.print("파란 초 " + blueCandle + "개, ");
		System.out.print("노란 초 " + yellowCandle + "개. ");
		System.out.println("총 " + totalCandle + "개가 필요합니다.");
		
		scanner.close();
	}

}
