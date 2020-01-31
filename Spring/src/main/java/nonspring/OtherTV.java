package nonspring;

public class OtherTV implements TV {
	// Power On/Off
	public void powerOn() {
		System.out.println("OtherTV : Power On");
	}
	public void powerOff() {
		System.out.println("OtherTV : Power Off");
	}
	
	// Volume Up/Down
	public void soundUp() {
		System.out.println("OtherTV : Volume Up");
	}
	public void soundDown() {
		System.out.println("OtherTV : Volume Down");
	}
}
