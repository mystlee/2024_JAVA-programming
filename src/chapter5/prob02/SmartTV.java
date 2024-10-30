
public class SmartTV extends ColorTV {
	private String ip;
	public SmartTV(String ip, int size, int colors) {
		super(size, colors);
		this.ip = ip;
	}
	
	@Override
	public void printProperty() {
		System.out.print("나의 SmartTV는 " + ip + " 주소의 ");
		super.printProperty();
	}
	
	public static void main(String[] args) {
		SmartTV smartTV = new SmartTV("192.168.0.5", 77, 20000000); // "192.168.0.5" 주소에 77인치 20000000 컬러 TV
		smartTV.printProperty();
	}

}
