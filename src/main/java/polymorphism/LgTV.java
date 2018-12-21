package polymorphism;

public class LgTV implements TV {
	
	public void powerOn() {
		System.out.println("LgTV---powerOn");
	}
	public void powerOff() {
		System.out.println("LgTV---powerOff");
	}
	public void volumeUp() {
		System.out.println("LgTV---volumeUp");
	}
	public void volumeDown() {
		System.out.println("LgTV---volumeDown");
	}
}
