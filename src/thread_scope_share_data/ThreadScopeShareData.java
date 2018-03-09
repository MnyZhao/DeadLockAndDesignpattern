package thread_scope_share_data;

import java.util.HashMap;
import java.util.Random;

/**
 * 多线程之间数据共享 通过map集合 将线程做为键 将数据作为值  最简单
 */
public class ThreadScopeShareData {
	private static int data=0;
	private static HashMap<Thread, Integer> threadDate=new HashMap<Thread, Integer>();
	public static void main(String[] args) {
		new Thread(new Runnable() {
			
			public void run() {
				 data=new Random().nextInt();
				 threadDate.put(Thread.currentThread(), data);
				new A().get();
				new B().get();
			}
		}).start();
	}
	static class A{
		public void get(){
			data=threadDate.get(Thread.currentThread());
			System.out.println("A from "+ Thread.currentThread().getName()+"getData:"+ data);
		
		}
	}
	static class B{
		public void get(){
			data=threadDate.get(Thread.currentThread());
			System.out.println("B from "+ Thread.currentThread().getName()+"getData:"+ data);
		}
	}
	static class C{
		public int get(){
			return data;
		}
	}
}
