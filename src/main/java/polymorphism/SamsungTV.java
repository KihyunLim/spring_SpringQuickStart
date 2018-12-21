package polymorphism;

public class SamsungTV implements TV {
	
	public SamsungTV() {
		System.out.println("===> SamsungTV 按眉 积己");
	}
	public void initMethod() {
		System.out.println("按眉 檬扁拳 累诀 贸府");
	}
	public void destroyMethod() {
		System.out.println("按眉 昏力 傈俊 贸府且 肺流 贸府");
	}
	public void powerOn() {
		System.out.println("SamsungTV---powerOn");
	}
	public void powerOff() {
		System.out.println("SamsungTV---powerOff");
	}
	public void volumeUp() {
		System.out.println("SamsungTV---volumeUp");
	}
	public void volumeDown() {
		System.out.println("SamsungTV---volumeDown");
	}
}
