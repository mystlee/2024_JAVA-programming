
public class ColorPoint2 extends Point {
	private String color=null;
	public ColorPoint2() {
		this(0, 0, "WHITE");
	}
	
	public ColorPoint2(int x, int y) {
		this(x, y, "BLACK");
	}
	
	public ColorPoint2(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	
	public void set(int x, int y) {
		move(x, y);
	}
	
	public void set(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return color + "색의 (" + getX() + "," + getY() + ")의 점";
	}
	
	public double getDistance(ColorPoint2 p) {
		int dx = getX()-p.getX();
		int dy = getY()-p.getY();
		return Math.sqrt((dx*dx) + (dy*dy));
	}
	
	public static void main(String[] args) {
		ColorPoint2 zeroPoint = new ColorPoint2(); // (0,0) 위치의 "WHITE" 색 점
		System.out.println(zeroPoint.toString() + "입니다.");
		
		ColorPoint2 cp = new ColorPoint2(10, 10, "RED"); // (10,10) 위치의 "RED" 색 점
		cp.set("BLUE");
		cp.set(10, 20);
		System.out.println(cp.toString() + "입니다.");
		ColorPoint2 thresholdPoint = new ColorPoint2(100, 100); // (100, 100) 위치의 "BLACK" 점 
		System.out.println("cp에서 임계점까지의 거리는 " + cp.getDistance(thresholdPoint));
	}

}
