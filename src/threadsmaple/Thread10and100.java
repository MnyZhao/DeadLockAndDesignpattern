package threadsmaple;

/**
 * 程循环10次，接着主线程循环100，
 * 接着又回到子线程循环10次，接着再回到主线程又循环100，如此循环50次，请写出程序。
 */
public class Thread10and100 {

    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {

            public void run() {
                // TODO Auto-generated method stub
                for (int i = 1; i <= 50; i++) {
                    business.sub(i);
                }
            }
        }).start();
        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }

    }


}
