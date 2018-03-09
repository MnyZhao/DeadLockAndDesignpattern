import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 通过信息量 Semaphore 来
 */
public class UnLockTest {
    public static String obj1 = "obj1";
    public static final Semaphore a1 = new Semaphore(1);
    public static String obj2 = "obj2";
    public static final Semaphore a2 = new Semaphore(1);

    public static void main(String[] args) {
        Thread t1 = new Thread(new UnLockA());
        t1.start();
        Thread t2 = new Thread(new UnLockB());
        t2.start();
    }
}

class UnLockA implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                if (UnLockTest.a1.tryAcquire(1, TimeUnit.SECONDS)) {
                    System.out.println(new Date().toString() + "->UnLockA.run 锁住obj1 等待锁住 obj2");
                    if (UnLockTest.a2.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println(new Date().toString() + "->UnLockA.run 锁住obj2");
                    } else {
                        System.out.println(new Date().toString() + "->UnLockA.run 锁住obj2 失败");
                    }
                } else {
                    System.out.println(new Date().toString() + "->UnLockA.run 锁住obj1 失败");
                }
                UnLockTest.a1.release(); // 释放
                UnLockTest.a2.release();
                Thread.sleep(1000); // 马上进行尝试，现实情况下do something是不确定的
            }
        } catch (Exception e) {
        }
    }
}

class UnLockB implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                if (UnLockTest.a2.tryAcquire(1, TimeUnit.SECONDS)) {
                    System.out.println(new Date().toString() + "->UnLockA.run 锁住obj2 等待锁住 obj1");
                    if (UnLockTest.a1.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println(new Date().toString() + "->UnLockA.run 锁住obj1");
                    } else {
                        System.out.println(new Date().toString() + "->UnLockA.run 锁住obj1 失败");
                    }
                } else {
                    System.out.println(new Date().toString() + "->UnLockA.run 锁住obj2 失败");
                }
                UnLockTest.a1.release(); // 释放
                UnLockTest.a2.release();
                Thread.sleep(1000); // 马上进行尝试，现实情况下do something是不确定的
            }
        } catch (Exception e) {
        }
    }
}
