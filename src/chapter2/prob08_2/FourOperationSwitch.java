import java.util.Scanner;

public class FourOperationSwitch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("연산 입력>>");
		double op1 = scanner.nextDouble();
		String op = scanner.next();		
		double op2 = scanner.nextDouble();
		
		double res = 0;
		switch(op) {
			case "더하기":
				res = op1 + op2;
				break;
			case "빼기":
				res = op1 - op2;
				break;
			case "곱하기":
				res = op1 * op2;
				break;		
			case "나누기":
				if(op2 == 0) {
					System.out.print("0으로 나눌 수 없습니다.");
					scanner.close();
					return;
				}
				res = op1 / op2;
				break;
			default :
				System.out.print("사칙연산이 아닙니다.");
				scanner.close();
				return;
		}
		System.out.print(op1 + " " + op + " " + op2 + "의 계산 결과는 " + res);
		scanner.close();
	}
}
