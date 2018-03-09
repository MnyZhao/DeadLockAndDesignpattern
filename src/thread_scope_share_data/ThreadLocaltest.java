package thread_scope_share_data;

import java.util.Random;

/**
 * 多线程之间数据共享 通过ThreadLocal
 */
public class ThreadLocaltest {
	static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
	static ThreadLocal<MyThreadScopeDate> myThreadLocal = new ThreadLocal<MyThreadScopeDate>();

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {
				public void run() {
					int data = new Random().nextInt();
					/*x.set(data);*/
					MyThreadScopeDate.getInstatnce().setName("name" + data);
					MyThreadScopeDate.getInstatnce().setAge( data);
				
					new A().get();
					new B().get();
				}
			}).start();
		}
	}

	static class A {
		public void get() {
			/*int data = x.get();*/

			/*System.out.println("A from " + Thread.currentThread().getName()
					+ "getData:" + data);*/
			MyThreadScopeDate myData = myThreadLocal.get();
			System.out.println("A from " + Thread.currentThread().getName()
					+ "getMyData:" + MyThreadScopeDate.getInstatnce().getName() + "Age: "
					+ MyThreadScopeDate.getInstatnce().getAge());

		}
	}

	static class B {
		public void get() {
			int data = x.get();
		/*	System.out.println("B from " + Thread.currentThread().getName()
					+ "getData:" + data);*/
			MyThreadScopeDate myData = myThreadLocal.get();
			System.out.println("B from " + Thread.currentThread().getName()
					+ "getMyData:" + MyThreadScopeDate.getInstatnce().getName() + "Age: "
					+ MyThreadScopeDate.getInstatnce().getAge());

		}
	}
}

class MyThreadScopeDate {
	public static /*synchronized*/ MyThreadScopeDate getInstatnce(){
		MyThreadScopeDate instance=map.get();
		if(instance==null){
			instance=new MyThreadScopeDate();
			map.set(instance);
		}
		/*return instance;*/
		return instance;
	}
	private static ThreadLocal<MyThreadScopeDate> map=new ThreadLocal<MyThreadScopeDate>();
	private String name;
	private int age;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}
}