package tvspring;

// 모든 TV들은 메소드 선언 일치 약속
// 구현 방법은 각 TV마다 다르다.
public interface TV {
	public void powerOn();
	public void powerOff();
	public void soundUp();
	public void soundDown();
}
