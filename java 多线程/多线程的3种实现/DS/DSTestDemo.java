package Multiprocess;


class MyThread4 extends Thread {
    //    private int ticket = 10;
    private static int ticket = 10;//类属性 共享资源

    @Override
    public void run() {
        while (this.ticket > 0) {
            System.out.println("剩余：" + this.ticket-- + "票");
        }
    }
}

class MYTheard4 implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println("剩余：" + this.ticket-- + "票");
        }
    }
}

public class DSTestDemo {
    public static void main(String[] args) {
        System.out.println("1.Thread描述共享资源");
        new MyThread4().start(); //线程1
        new MyThread4().start(); //线程2
        new MyThread4().start(); //线程3
        //看似三个线程同时在买票其实上是，各自在卖各自的票
        //并没有共享资源的概念。
        //除非将该数据是本身就是共享资源（类属性）
        System.out.println("2.Runnable描述共享资源");
        MYTheard4 mt = new MYTheard4();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();


    }
}
