import static java.lang.Thread.sleep;

class MyThread implements Runnable {
    private int ticket = 10;

//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            synchronized (this) {      //必须指定对象
//                if (this.ticket > 0) {
//                    try {
//                        sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "还剩下" + this.ticket-- + "票");
//                }
//
//            }
//        }
//    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sale();
        }
    }
//隐式锁的是this对象 也只能是this对象
    public synchronized void sale() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "还剩下" + this.ticket-- + "票");
        }
    }
}


public class Synchronization {
    public static void main(String[] args) {
        Runnable mt = new MyThread();
        Thread thread1 = new Thread(mt, "黄牛A");
        Thread thread2 = new Thread(mt, "黄牛B");
        Thread thread3 = new Thread(mt, "黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
