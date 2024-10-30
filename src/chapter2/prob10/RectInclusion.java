import java.util.Scanner;

public class RectInclusion {
	static final int X1 = 10;
	static final int Y1 = 10;
	static final int X2 = 200;
	static final int Y2 = 300;

//	 (px, py)가 (x1, y1)과 (x2, y2)로 구성되는 사각형 내부에 있으면 true, 아니면 false 리턴
	public static boolean inRect(int px, int py, int x1, int y1, int x2, int y2) {
		if((px >= x1 && py <= x2) && (py >= y1 && py <= y2))
			return true;
		else
			return false;
	}

	public static boolean contains(int x1, int y1, int x2, int y2) {
//		 (X1, Y1), (X2, Y2) 사각형이 (x1, y1), (x2, y2) 사각형에 포함하는 경우 true 리턴
		if(inRect(x1, y1, X1, Y1, X2, Y2) &&
				inRect(x1, y2, X1, Y1, X2, Y2) && 
				inRect(x2, y1, X1, Y1, X2, Y2) && 
				inRect(x2, y2, X1, Y1, X2, Y2))
			return true;
		else
			return false;
	}

	
	public static void main (String args[])  {
		Scanner scanner = new Scanner(System.in);
		System.out.print("(x1, y1), (x2, y2)의 좌표 입력>>");
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();

		System.out.print("(" + x1 + "," + y1 + ") (" + x2 + "," + y2 + ") 사각형은 (" + X1 + "," + Y1 + ") (" + X2 + "," + Y2 + ") 사각형에 ");
		if(contains(x1, y1, x2, y2)) 
			System.out.println("포함된다.");
		else
			System.out.println("포함되지 않는다");
		
		scanner.close();
	}
}
