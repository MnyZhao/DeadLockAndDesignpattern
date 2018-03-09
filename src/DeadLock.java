import java.util.Date;

/**
 * why deadLock
 * 什么是线程死锁
 * 当A线程持有互斥锁Lock1 线程B持有互斥锁Lock2,
 * 当线程A仍然持有Lock1 时A 试图获取lock2 线程B刚好持有Lock2 因此A 线程会阻塞等待B线程对lock2释放
 * 如果此时B线程在持有lock2 的时候试图获取lock1 因为A持有Lock1 所以 B 线程会阻塞等待A线程释放lock1
 * 这样二者都在等待对方所持有锁的释放，二者又都没有释放自己所持有的锁  二者会一直阻塞 这样称为死锁
 */
public class DeadLock {
    public static String obg1 = "obj1";
    public static String obg2 = "obj2";

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Thread t1 = new Thread(new LockA());
        t1.start();
        Thread t2 = new Thread(new LockB());
        t2.start();

    }
}

class LockA implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (DeadLock.obg1) {
                    System.out.println(new Date().toString() + "->LockA.run 锁住obj1 等待obj2");
                    Thread.sleep(3000);
                    synchronized (DeadLock.obg2) {
                        System.out.println(new Date().toString() + "->LockA.run 锁住obj2");
                        Thread.sleep(60 * 1000); // 为测试，占用了就不放
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}

class LockB implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (DeadLock.obg2) {
                    System.out.println(new Date().toString() + "->LockB.run 锁住obj2 等待obj1");
                    Thread.sleep(3000);
                    synchronized (DeadLock.obg1) {
                        System.out.println(new Date().toString() + "->LockB.run 锁住obj1");
                        Thread.sleep(60 * 1000); // 为测试，占用了就不放
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
