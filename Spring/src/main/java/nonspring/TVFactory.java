package nonspring;

public class TVFactory {
	public TV getTV(String name) {
		if(name.equals("Multi")) {
			return new MultiTV();
		} else if(name.equals("Other")) {
			return new OtherTV();
		}
		return null;
	}
}
