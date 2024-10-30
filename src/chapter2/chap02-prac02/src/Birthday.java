import java.util.Scanner;

public class Birthday {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("생일 입력 하세요>>");
		int n = scanner.nextInt();
		int year = n/10000; // 년도 알아내기
		
		n = n % 10000; // 월일 부분 끊어내기
		int month = n / 100; // 월 알아내기 
		
		int day = n % 100; // 일 부분 끊어내기		
		
		System.out.println(year + "년 " + month + "월 " + day + "일");
		
		scanner.close();
	}

}
