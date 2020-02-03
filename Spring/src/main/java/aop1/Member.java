package aop1;

public class Member {
	public void login(String id) {
		System.out.println("Login Success, Hi " + id);
	}
	
	public void logout() {
		System.out.println("Logout Success");
	}
}
