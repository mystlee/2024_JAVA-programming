import java.util.Scanner;

public class TravelCost {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("여행지>>");
		String place = scanner.nextLine();
		
		System.out.print("인원수>>");
		int person = scanner.nextInt();
		
		System.out.print("숙박일>>");
		int day = scanner.nextInt();
		
		System.out.print("1인당 항공료>>");
		int airplane = scanner.nextInt();

		System.out.print("1방 숙박비>>");
		int hotel = scanner.nextInt();


		// 방 개수 계산
		int room  = 0;
		room = person/2 + person%2;
		/* 아래와 같이 구현해도 됨
		if(person%2 == 1)
			room = person/2 + 1;
		else 
			room = person/2;			
		*/
		// 전체 비용 계산
		int cost = room*hotel*day + person*airplane;
		
		System.out.println(person + "명의 " + place + " " + day + "박 " + (day+1) + "일 여행에는 방이 "
				+ room + "개 필요하며 경비는 " + cost + "원입니다.");
		
		scanner.close();
	}

}
