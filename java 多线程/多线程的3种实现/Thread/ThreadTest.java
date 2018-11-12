/**
 * java.lang.Thread 是一个线程操作的核心类。新建一个线程最简单的方法就是直接继承
 * Thread类，而后覆写该类种的run（）方法（就相当于主类种的main方法）
 */
class MyThread2 extends Thread { //线程主体类
    private String title;

    public MyThread2(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + ",i=" + i);
        }
    }
}


public class ThreadTest {
    public static void main(String[] args) {
        Thread thread1 = new MyThread2("线程A");
        Thread thread2 = new MyThread2("线程B");
        Thread thread3 = new MyThread2("线程C");
        thread1.start();  //启动线程
        thread2.start();
        thread3.start();

//        thread.run();    //相当与普通方法，与多线程无关


    }
}


