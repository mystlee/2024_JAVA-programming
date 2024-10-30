import java.util.Scanner;

public class FourOperationIf {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("연산 입력>>");
		double op1 = scanner.nextDouble();
		String op = scanner.next();		
		double op2 = scanner.nextDouble();
		
		double res = 0;
		if(op.equals("더하기")) 
			res = op1 + op2;
		else if(op.equals("빼기")) 
			res = op1 - op2;
		else if(op.equals("곱하기")) 
			res = op1 * op2;
		else if(op.equals("나누기")) {
			if(op2 == 0) { 
				System.out.print("0으로 나눌 수 없습니다.");
				scanner.close();
				return;
			}
			else
				res = op1 / op2;
		}
		else {
			System.out.print("사칙연산이 아닙니다.");
			scanner.close();
			return;
		}
		System.out.print(op1 + " " + op + " " + op2 + "의 계산 결과는 " + res);
		scanner.close();
	}
}
