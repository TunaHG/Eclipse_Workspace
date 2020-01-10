package Day09;

import javax.swing.JOptionPane;

public class Test03_anony {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller cmd = new DeleteController();
		cmd.exec();

		Controller insert = new Controller() {
			@Override
			public void exec() {
				System.out.println("insert Execute");
			}
		};
		
		Controller update = new Controller() {
			
			@Override
			public void exec() {
				// TODO Auto-generated method stub
				System.out.println("update Execute");
			}
		};
		
		Controller delete = new Controller() {
			
			@Override
			public void exec() {
				// TODO Auto-generated method stub
				System.out.println("delete Execute");
			}
		};
		
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

interface Controller {
	void exec();
}

class DeleteController implements Controller {

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		System.out.println("DeleteController 수행");
	}

}