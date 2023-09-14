package SOExerc0109.controller;

public class ThreadId extends Thread {

private int IdThread;	

	public ThreadId(int IdThread) {
		this.IdThread = IdThread;
	}
	

	public void run() {
		System.out.println(IdThread);
	}	

}
