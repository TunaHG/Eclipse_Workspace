package Workshop5.Prob05;

public class Otab extends Mobile {
	public Otab() {
		super();
	}
	public Otab(String mobileName, int batterySize, String osType) {
		super();
		setMobileName(mobileName);
		setBatterySize(batterySize);
		setOsType(osType);
	}
	
	@Override
	public int operate(int time) {
		setBatterySize(getBatterySize() - time * 12);
		return getBatterySize();
	}
	
	@Override
	public int charge(int time) {
		setBatterySize(getBatterySize() + time * 8); 
		return getBatterySize();
	}
}
