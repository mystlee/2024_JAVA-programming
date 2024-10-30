public class PositivePoint extends Point {
	public PositivePoint(int x, int y) {
		super(x, y);
		if (x < 1 || y < 1)
			super.move(1, 1);
	}

	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + ")의 점";
	}

	@Override
	public void move(int x, int y) {
		if (x < 1 || y < 1)
			super.move(x, y);
		// 양수 공간이 아니면, move() 하지 않음
	}

	public static void main(String[] args) {
		PositivePoint p = new PositivePoint(10, 10); // (10, 10)의 점
		p.move(5, 5); // p는 (5, 5) 점
		System.out.println(p.toString() + "입니다.");

		p.move(2, -2); // 점 p는 양수 공간만 가능. 그러므로 이동 없음
		System.out.println(p.toString() + "입니다.");

		PositivePoint q = new PositivePoint(-10, -10); // 음수 점 불가. 디폴트 (1, 1)의 점 생성
		System.out.println(q.toString() + "입니다.");
	}

}
