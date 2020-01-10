package Prob;

public class Application {

	public static void main(String[] args) {
		userDAO ud = new userDAO();
		
		System.out.println(ud.loginUser("asdf0185", "1q2w3e001"));
	}

}
