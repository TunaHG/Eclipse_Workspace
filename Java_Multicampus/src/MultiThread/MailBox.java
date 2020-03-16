package MultiThread;

class MailBox {
	private String message;
	private boolean request;
	
	public synchronized void storeMessage(String message) {
		while(request == true) {
			try {
				wait();
			} catch(InterruptedException e) {
				
			}
		}
		request = true;
		this.message = message;
		notify();
	}
	
	public synchronized String retrieveMessage() {
		while(request == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		request = false;
		return message;
	}
}
