
class MyThread implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("还剩下" + ticket-- + "票");
        }
    }
}


public class RunnableTest {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread thread1 = new Thread(mt);
        Thread thread2 = new Thread(mt);
        Thread thread3 = new Thread(mt);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
