package Day09;

import javax.swing.JOptionPane;

public class Test01_default {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Command cmd = null;
		
		String msg = JOptionPane.showInputDialog("명령을 입력하세요. Delete=1, Insert=2, Update=3");
		
		switch(msg) {
		case "1":
		case "Delete":
			cmd = new DeleteCommand();
			break;
		case "2":
		case "Insert":
			cmd = new InsertCommand();
			break;
		case "3":
		case "Update":
			cmd = new UpdateCommand();
			break;
		default:
			cmd = new ListCommand();
		}
		
		if(cmd != null) {
			cmd.exec();
			cmd.base();
		}
	}

}

interface Command {
	void exec();
	default public void base() {
		System.out.println("Command base() 기능");
	}
}

class DeleteCommand implements Command {

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		System.out.println("DeleteCommnad 수행");
	}
	
}

class UpdateCommand implements Command {

	@Override
	public void exec() {
		// TODO Auto-generated method stub
		System.out.println("UpdateCommand 수행");
	}
	
	@Override
	public void base() {
		System.out.println("Command base() 재정의");
	}
}

class InsertCommand implements Command {
	
	@Override
	public void exec() {
		// TODO Auto-generated method stub
		System.out.println("InsertCommand 수행");
	}
	
}

class ListCommand implements Command {
	public void exec() {
		System.out.println("ListCommand 수행");
	}
}