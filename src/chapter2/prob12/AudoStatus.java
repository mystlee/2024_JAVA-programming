import java.util.Scanner;

public class AudoStatus {
	public static void main (String args[])  {
		Scanner scanner = new Scanner(System.in);
		System.out.print("자동차 상태 입력>>");
		int status = scanner.nextInt();
		int temp = status % 32;
		int aircon = status & 0b01000000;
		int running = status & 0b10000000;
		
		System.out.print("자동차는 ");
		if(running == 0) {
			System.out.print("정지 상태이고 ");
		}
		else {
			System.out.print("달리는 상태이고 ");			
		}
		
		if(aircon == 0) {
			System.out.print("에어컨이 꺼진 상태이고 ");
		}
		else {
			System.out.print("에어컨이 켜진 상태이고 ");			
		}		
		
		System.out.println("온도는 " + temp +"도이다.");
		scanner.close();
	}
}
