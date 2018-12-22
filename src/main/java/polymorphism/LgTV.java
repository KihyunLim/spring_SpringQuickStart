package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV {
	
	@Autowired
	/*@Autowired
	@Qualifier("apple")*/
//	@Resource(name="apple")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("===> LgTV 객체 생성");
	}
	public void powerOn() {
		System.out.println("LgTV---powerOn");
	}
	public void powerOff() {
		System.out.println("LgTV---powerOff");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
