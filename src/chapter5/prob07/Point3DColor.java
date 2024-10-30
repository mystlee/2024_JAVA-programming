
public class Point3DColor extends Point {
	private int z;
	private String color;
	public Point3DColor(int x, int y, int z, String color) {
		super(x, y);
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + "," + z + ")" + color + "점";
	}
	
	public void move(Point3DColor q) {
		move(q.getX(), q.getY());
		this.z = q.z;
	}
	
	public boolean equals(Point3DColor q) {
		if(getX() == q.getX() && getY() == q.getY() && z == q.z && color.equals(q.color)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Point3DColor p = new Point3DColor(10, 20, 30, "RED");
		System.out.println(p.toString() + "입니다.");
		
		Point3DColor q = new Point3DColor(1, 2, 3, "BLUE");
		p.move(q); // 점 p를 점 q의 위치로 이동
		System.out.println(p.toString() + "입니다.");
		
		Point3DColor r = new Point3DColor(1, 2, 3, "RED");
		if(p.equals(r)) 
			System.out.println("예. 같은 위치 같은 색깔의 점입니다.");
		else
			System.out.println("아니오");	
	}

}
