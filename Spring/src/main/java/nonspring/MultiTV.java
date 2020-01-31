package nonspring;

public class MultiTV implements TV {
	// Power On/Off
	public void powerOn() {
		System.out.println("MultiTV : Power On");
	}
	public void powerOff() {
		System.out.println("MultiTV : Power Off");
	}
	// Volume Up/Down
	public void soundUp() {
		System.out.println("MultiTV : Volume Up");
	}
	public void soundDown() {
		System.out.println("MultiTV : Volume Down");
	}
}
