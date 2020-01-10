package Day09;

import javax.swing.JOptionPane;

public class Test04_lambda {

	public static void main(String[] args) {
		Controller cmd = new DeleteController();
		cmd.exec();

		Controller insert = () -> System.out.println("insert Execute");
		Controller update = () -> System.out.println("update Execute");
		Controller delete = () -> System.out.println("delete Execute");
		
		String msg = JOptionPane.showInputDialog("명령을 입력하세요. Delete=1, Insert=2, Update=3");
		
		switch(msg) {
		case "1":
		case "Delete":
			cmd = delete;
			break;
		case "2":
		case "Insert":
			cmd = insert;
			break;
		case "3":
		case "Update":
			cmd = update;
			break;
		default:
			System.out.println("잘못된 명령어입니다.");
		}
		
		if(cmd != null) cmd.exec();
	}

}