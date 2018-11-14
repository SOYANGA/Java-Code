package ThreadMethods;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.sleep;
import static java.lang.Thread.yield;

/**
 * 线程间的常用方法API
 */
class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //线程命名以及取得
            System.out.println("当前线程：" + Thread.currentThread().getName() + ",i=" + i);
        }
    }
}

class MyThread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000);  //受查异常！！
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程：" + Thread.currentThread().getName() + ",i=" + i);
        }
    }
}

public class ThreadMethod {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        //一、线程命名以及取得
//        new Thread(mt).start();//没有设置名字
//        new Thread(mt).start();//没有设置名字
//        new Thread(mt, "hahaha").start();//设置有名字

        //二、线程休眠
        MyThread1 mt1 = new MyThread1();
        new Thread(mt1).start();
        new Thread(mt1).start();
        new Thread(mt1).start();
        //三个线程交替使用CPU
        //看似同步执行其实是分别执行，在线程间快速的来回切换，保存加载上下文。
        //这个也就是的：并发执行

        //三、线程让步

    }
}

//一、线程的名字命名和取得

//创建线程的时候设置名字 -构造方法
//public Thread(Runnable target,String name);

//设置线程的名字  -普通方法
//public final sychronized void setName(String name);

//取得线程的名字 -普通方法
//public final String getName();

//由于想要使用普通的对象方法，则必须要有能获得线程对象的方法
//Thread类提供一个方法取得当前线程的对象

//public static native Thraad currentThread();

//如果没有设置名字线程会自动分配一个线程名字
//注意的是：线程名字如果要设置请避免重复，同时中间不要修改。

//线程并不是用名字区分线程的，线程名字可以重复，但尽量避免点名。


//二、线程休眠（sleep方法) --回阻塞态

//public static native void sleep(long mills) throws InterruptException
//  单位是ms。
//InterruptException:   受查异常  （需要处理）

//线程休眠：指的是让线程暂缓执行一下，等到预计时间后再恢复执行。

//线程休眠时会交出CPU，让CPU去执行其他任务。但是有一点要非常注意，
// sleep方法不会释放锁，也就说当前线程持有对某个对象的锁，则即使调用sleep()方法，
//其他线程也无法访问这个对象
//


//三、线程让步（yield()方法)  --回就绪态
//暂停当前正在执行的线程对象，并执行其他线程。

//意思就是调用yeild（）方法会让当前线程交出CPU权限，让CPU去执行其它的线程。它跟sleep方法
//有些类似，同样不会释放锁。但是yeild()不能控制具体的交出CPU的时间，另外，yeild方法只能让
//拥有相同优先级的线程有获取CPU执行时间的机会。

//注意，调用yeild方法并不会让线程进入阻塞状态，而是让线程重回就绪状态，它只需要等待
//重新获取CPU执行时间，这一点是和sleep方法不一样的地方。


///进程间的通信--------------方法
//class MyThread1 extends Thread {
//    private int ticket = 10;
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(currentThread().getName() + "   " + i);
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//
//public class ThreadMethod {
//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("main线程开始----");
//        Thread thread1 = new MyThread1();
//        Thread thread2 = new MyThread1();
//        thread1.start();
//        thread1.join();
//        System.out.println("main线程开始----");
//
//    }
//}