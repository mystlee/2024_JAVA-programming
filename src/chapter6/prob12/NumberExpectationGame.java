import java.util.Scanner;

public class NumberExpectationGame {
	static final int NUMBERS = 15; // 랜덤하게 발생시킬 정수 개수
	private Player [] players = null;
	private Scanner scanner = new Scanner(System.in);
	
	public NumberExpectationGame() { }
	
	private void createPlayers() {
		System.out.print("게임에 참여할 선수들 이름>>");
		String line = scanner.nextLine(); // 버퍼에 입력된 <Enter>키 제거.
		String [] names = line.split(" "); // 빈 칸으로 입력된 이름들 분리
		
		// 선수 이름 개수만큼 Player 객체 배열 생성
		players = new Player [names.length]; 
		for(int i=0; i<players.length; i++) {
			players[i] = new Player(names[i]);
		}		
	}
	
	private void chooseNumber() {
		// 선수 별 선호 번호 입력
		for(int i=0; i<players.length; i++) {
			System.out.print("[" + players[i].getName() + "] 정수 선택(1~10)>>");
			int n = Integer.parseInt(scanner.nextLine()); // 한 라인을 읽고 정수로 바꿈.
			// 이렇게 코딩하는 이유는, 만일 nextInt()로 읽으면 정수만 읽고 <Enter>키가 입력 버퍼에 남게 되고
			// 다음에 nextLine()으로 읽을 때, 현재 남아 있는 <Enter>키를 바로 입력하게 되기 때문
			
			players[i].setNumber(n);
		}		
	}
	
	private void doGame() {
		int num [] = new int [NUMBERS]; // 랜덤하게 생성된 정수들을 저장할 배열
		
		while(true) { // 패자가 1명 생길 때까지 계속
			// 랜덤한 정수들 생성 및 저장
			System.out.print("Enter키 입력>>");
			scanner.nextLine(); // <Enter>키 입력할 때까지 대기
			
			for(int i=0; i<NUMBERS; i++) {
				int n = (int)(Math.random()*10 + 1); // 1~10 사이의 랜덤 정수
				num[i] = n;
			}
			
			// 모든 정수들 출력
			for(int i=0; i<NUMBERS; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			
			// 각 선수들이 선택한 정수와 일치하는지 판단하여 히트 카운트 증가
			for(int i=0; i<NUMBERS; i++) {
				for(int j=0; j<players.length; j++) {
					if(players[j].getLoser() == true) { // 실패자에 대해서면 
						if(num[i] == players[j].getNumber()) {
							players[j].hit(); // 예측 성공. 히트 카운트 증가
						}
					}
				}
			}
			
			/// 실패자들에 대해서면 히트 카운트 출력
			for(int i=0; i<players.length; i++) {
				if(players[i].getLoser() == true)  
					System.out.println("[" + players[i].getName() + "] 맞춘 개수: " + players[i].getHitCount());
			}

			
			// 가장 낮은 히트 카운트 결정
			int lowCount = 100; // 의도적으로 큰 숫자 100을 설정
			for(int i=0; i<players.length; i++) {
				if(players[i].getHitCount() < lowCount) {
					lowCount = players[i].getHitCount(); // lowCount 변경
				}
			}
	
			// lowCount 값의 히트 카운트를 가진 선수만 패자로 남겨둠
			System.out.print("현재 패자들 : ");
			int loserCount = 0;
			for(int i=0; i<players.length; i++) {
				if(players[i].getHitCount() != lowCount) { // 패자가 아닌 경우
					players[i].setLoser(false); // 패자가 아닌 것으로 표시
				}
				else { // 패자인 경우
					System.out.print(players[i].getName() + " "); // 패자 이름 출력
					loserCount++;
				}
			}
			System.out.println();
			
			if(loserCount == 1) { // 패자가 1명인 경우
				int i=0;
				for(i=0; i<players.length; i++) {
					if(players[i].getHitCount() == lowCount) {
						break; // 패자는 player[i];
					}
				}
				
				System.out.println("\n최종 패자는 " + players[i].getName() + "입니다.");
				break;
			}
			else { // 패자가 여러명일 때 재대결
				// 패자들의 히트 카운트를 0으로 초기화
				for(int i=0; i<players.length; i++) {
					if(players[i].getLoser() == true) {
						players[i].clearHitCount();
					}
				}
			}
		}
	}
	
	public void run() {
		createPlayers();
		chooseNumber();
		doGame();
	}
	public static void main(String[] args) {
		NumberExpectationGame game = new NumberExpectationGame();
		game.run();
	}

}
