package polymorphism;

public class SamsungTV implements TV {
	
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 객체 생성");
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리");
	}
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리");
	}
	public void powerOn() {
		System.out.println("SamsungTV---powerOn (가격: " + price + ")");
	}
	public void powerOff() {
		System.out.println("SamsungTV---powerOff");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
