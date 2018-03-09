package threadsmaple;

/**
 * 线程A对j++ B对J--
 * 由此引出 线程之间共享数据 以及 子线程循环10次主线程循环100次的例子里面 合理的阻塞唤醒
 */
public class MultiThreadSharendData {
	private int j;

	public static void main(String[] args) {
	    MultiThreadSharendData mu=new MultiThreadSharendData();
	    Incs inc=  mu.new Incs();
	    Decs dec=  mu.new Decs();
		for(int i=0;i<2;i++){
			new Thread(inc).start();
			new Thread(dec).start();
		}
	}

	private synchronized void inc() {
		j++;
		System.out.println("j++:" + j);
	}

	private synchronized void dec() {
		j--;
		System.out.println("j--:" + j);
	}

	class Incs implements Runnable {

		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 10; i++) {
				inc();
			}
		}

	}

	class Decs implements Runnable {

		public void run() {
			// TODO Auto-generated method stub
			for (int i = 0; i < 10; i++) {
				dec();
			}
		}

	}
}
