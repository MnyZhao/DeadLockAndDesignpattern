package threadsmaple;

public class Business {
	/*是不是子线程*/
	private boolean isShouldSub = true;

	public synchronized void sub(int i) {
		while (!isShouldSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println("sub thread " + j + "loop of i:" + i);
		}
		isShouldSub=false;
		this.notify();
	}

	public synchronized void main(int i) {
		while (isShouldSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 100; j++) {
			System.out.println("main thread " + j + "loop of i:" + i);
		}
		isShouldSub=true;
		this.notify();
	}
}
