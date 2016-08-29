package task.three;

public class ConcurrencyIssue {

	//The fix would be adding `transient` to both values. 
	//Otherwise the changes in the new thread may not be visible to main thread.
	private transient boolean hasResult = false;
	private transient int result = 0;

	public void go() {

		//in the original question, the programmer forgot to call `run` method of the new thread
		new Thread(new Runnable() {
			public void run() {
				result = 1 + 1;
				hasResult = true;
			}
		}).run();

		while (!hasResult) {
		}

		System.out.println(result); // 2
	}

	public static void main(String args[]) {
		ConcurrencyIssue ci = new ConcurrencyIssue();
		ci.go();
	}

}
