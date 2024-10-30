interface Shape {
	static final double PI = 3.14;
	void draw(); // 도형을 그리는 추상 메소드. 상속받으면 구현 필요
	double getArea(); // 도형의 면적을 리턴하는 추상 메소드. 상속받으면 구현 필요
	default public void redraw() { // 디폴트 메소드
		System.out.print("--- 다시 그립니다. ");
		draw();	
	}
}

class Circle implements Shape {
	private int radius; // 반지름

	public Circle(int radius) { 
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		System.out.println("반지름이 " + radius + "인 원");
	}
	
	@Override
	public double getArea() { 
		return PI*radius*radius;
	}
}

class Oval implements Shape {
	private int width, height; // 가로와 세로
	
	public Oval(int width, int height) { 
		this.width = width; 
		this.height = height; 
	}
	
	@Override
	public void draw() { 
		System.out.println(width + "x" + height + "에 내접하는 타원");
	}
	
	@Override
	public double getArea() { 
		return PI*width*height;
	}
}

class Rect implements Shape {
	private int width, height; // 가로와 세로
	
	public Rect(int width, int height) { 
		this.width = width; this.height = height;
	}
	
	@Override
	public void draw() { 
		System.out.println(width + "x" + height + "크기의 사각형");
	}
	
	@Override
	public double getArea() { 
		return width*height;
	}
}

public class ShapeEx {

	public static void main(String[] args) {
		Shape [] list = new Shape[3]; // Shape을 상속받은 클래스 객체의 레퍼런스 배열
		list[0] = new Circle(5); // 반지름이 5인 원 객체
		list[1] = new Oval(20, 30); // 20x30 사각형에 내접하는 타원
		list[2] = new Rect(10, 40); // 10x40 크기의 사각형

		for(int i=0; i<list.length; i++) list[i].redraw();
		for(int i=0; i<list.length; i++) System.out.println("면적은 " + list[i].getArea());
	}

}
