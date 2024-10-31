// 선수를 나타내는 클래스
public class Player {
	private String name; // 선수 이름
	private int number; // 선수가 선택한 정수
	private int hitCount = 0; // 예측한 정수가 일치한 개수. 히트 카운트
	private boolean loser = true; // 패자인지를 나타내는 불린 값으로 패자들에 대해서만 게임 진행, 
			// 그러므로 패자로 초기화
			// 게임에서 가장 낮은 hitCount를 가진 경우, 패자이며 true
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() { return name; }

	public void setNumber(int number) { 
		this.number = number;
	}

	public int getNumber() { 
		return number;
	}

	public void hit() {
		hitCount++;
	}
	
	public int getHitCount() {
		return hitCount;
	}
	
	public void clearHitCount() {
		hitCount = 0;
	}

	public void setLoser(boolean mark) { 
		loser = mark;
	}
	
	public boolean getLoser() { 
		return loser;
	}

}
