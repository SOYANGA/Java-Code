//class MyThread1 extends Thread {
//    private int ticket = 10;
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(currentThread().getName() + "   " + ticket-- + "票");
//        }
//    }
//}
//
//
//public class TheadTest {
//    public static void main(String[] args) {
//        Thread thread1 = new MyThread1();
//        Thread thread2 = new MyThread1();
//        Thread thread3 = new MyThread1();
//        thread1.setName("hahah");
//        thread1.start();
//        thread2.start();
//        thread3.start();
//    }
//}

import static java.lang.Thread.sleep;
import static java.lang.Thread.yield;

//进程间的通信--------------方法
class MyThread1 extends Thread {
    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(currentThread().getName() + "   " + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class TheadTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main线程开始----");
        Thread thread1 = new MyThread1();
        Thread thread2 = new MyThread1();
        thread1.start();
        thread1.join();
        System.out.println("main线程开始----");

    }
}
