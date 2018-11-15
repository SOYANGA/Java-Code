package ThreadMethods;


import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Thread.*;

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

class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Thread.yield();
            System.out.println("当前线程：" + Thread.currentThread().getName() + ",i=" + i);
        }
    }
}

class MyThread3 implements Runnable {
    @Override
    public void run() {

        try {
            System.out.println("主线程睡眠时间");
            ThreadMethod.printTime();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName());
            System.out.println("睡眠结束时间");
            ThreadMethod.printTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread5 implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            try {
                Thread.sleep(1000);
                System.out.println("第" + i + "次执行，线程名称为：" + Thread.currentThread().getName());
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}

class MyThread6 implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        int i = 1;
        while (flag) {
            try {
                /**
                 * 这里阻塞之后，线程就被调用了interrupt()方法
                 * 线程清除中断标志，就会抛出一个异常
                 * java.lang.InterruptedException
                 */
                Thread.sleep(1000);
                boolean bool = Thread.currentThread().isInterrupted();
                if (bool) {
                    System.out.println("非阻塞情况下执行操作，线程状态：是否被中断" + bool);
                }
                System.out.println("第" + i + "次执行，线程名称为：" + Thread.currentThread().getName());
                i++;
            } catch (InterruptedException e) {
                System.out.println("退出了");
                /**
                 * 这里退出阻塞状态，且中断标志被系统自动清除
                 * 并且重设置为false,所以此处bool为false
                 */
                boolean bool = Thread.currentThread().isInterrupted();
                System.out.println(bool);
                //退出run方法，中断进程
                return;
            }

        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class A implements Runnable {
    @Override
    public void run() {
        System.out.println("A优先级为：" + Thread.currentThread().getPriority());
        Thread thread = new Thread(new B());
        thread.start();
    }
}

class B implements Runnable {
    @Override
    public void run() {
        System.out.println("B优先级为：" + Thread.currentThread().getPriority());

    }
}

class C implements Runnable {
    private int i;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("线程名称：" + Thread.currentThread().getName() + ",i=" + i +
                        "是否为守护线程：" + Thread.currentThread().isDaemon());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("线程名称：" + Thread.currentThread().getName() + "中断了线程");
        }
    }
}


public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        //一、线程命名以及取得
//        new Thread(mt).start();//没有设置名字
//        new Thread(mt).start();//没有设置名字
//        new Thread(mt, "hahaha").start();//设置有名字

        //二、线程休眠 sleep()  立即交出cpu  进入阻塞态
//        MyThread1 mt1 = new MyThread1();
//        new Thread(mt1).start();
//        new Thread(mt1).start();
//        new Thread(mt1).start();
        //三个线程交替使用CPU
        //看似同步执行其实是分别执行，在线程间快速的来回切换，保存加载上下文。
        //这个也就是的：并发执行

        //三、线程让步  yield() 不一定会立即交出cpu ,回到就绪态
        // 经过系统调度将资源分配给优先级相同的线程
//        MyThread2 mt2 = new MyThread2();
//        new Thread(mt2).start();
//        new Thread(mt2).start();
//        new Thread(mt2).start();

        //四、线程等待 join()等待其他线程执行完毕后再去执行
        // 意思就是如果在主线程中调用该方法时就会让主线程休眠，
        // 让调用该方法的线程run方法先执行 完毕之后在开始执行主线程。
//        MyThread3 mt3 = new MyThread3();
//        Thread thread3 = new Thread(mt3, "子线程A");
//        thread3.start();
//        System.out.println(Thread.currentThread().getName());
//        thread3.join();  //等待子线程A结束后，再结束。进入阻塞状态（主线程）
//        System.out.println("代码结束");

        //五、线程终止

        //5.1手工设计标志位
//        MyThread5 mt5 = new MyThread5();
//        Thread thread5 = new Thread(mt5, "子线程A");
//        thread5.start();
//        Thread.sleep(2000);
//        mt5.setFlag(false);
//        Thread.sleep(100);
//        System.out.println("代码结束");

        //5.2stop（） 过期方法  不安全
//        thread5.start();
//        Thread.sleep(3000);
//        thread5.stop();    //立刻使进程结束
//        System.out.println("代码结束");

        //5.3 interrup() 系统设置的标记位 标记线程状态的。用接口判断线程状态
//        MyThread6 mt6 = new MyThread6();
//        Thread thread6 = new Thread(mt6, "子线程A");
//        thread6.start();
//        Thread.sleep(3000);
//        thread6.interrupt();  //将字线程A线程状态 -中断标记位设置为中断
//        Thread.sleep(100);
//        System.out.println("代码结束！");


        //6.设置优先级
//        System.out.println(Thread.currentThread().getPriority());
//        MyThread mt7 = new MyThread();
//        Thread t1 = new Thread(mt7, "1");
//        Thread t2 = new Thread(mt7, "2");
//        Thread t3 = new Thread(mt7, "3");
//        t1.setPriority(Thread.MIN_PRIORITY);
//        t2.setPriority(Thread.NORM_PRIORITY);
//        t3.setPriority(Thread.MAX_PRIORITY);
//        t2.start();
//        t1.start();
//        t3.start();
        //线程优先级的继承性
//        Thread thread = new Thread(new A()); //10
//        thread.setPriority(Thread.MAX_PRIORITY);//10
//        thread.start();

        //7.守护线程
        Thread thread7 = new Thread(new C(), "子线程A");
        //设置线程A为守护线程，此语句必须在start方法前执行
        thread7.setDaemon(true);
        thread7.start();

        //用户线程B
        Thread thread8 = new Thread(new C(), "子线程B");
        thread8.start();
        Thread.sleep(3000);
        //中断非守护线程
        thread8.interrupt();
        Thread.sleep(10000);
        System.out.println("代码结束");
        //从上面的代码可以看出来，B是用户线程当它中断了之后守护线程还没有结束，
        // 是因为主线程（用户线程）还没有结束，
        // 所以说明是所有的用户线程结束之后守护线程才会结束。
    }


    public static void printTime() {  //打印日期
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        System.out.println(time);
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


///四、线程等待 join()
// 等待其他线程执行完毕后再去执行。
// 意思就是如果在主线程中调用该方法时就会让主线程休眠，
// 让调用该方法的线程run方法先执行 完毕之后在开始执行主线程。


//五、线程停止 -(三种方式可以停止线程)

//1.设置标记位（手工）
//2.使用stop方法强制使线程退出，但是该方法不太安全所以已经被放弃了。
//为什么说不安全？因为stop会解除由线程获取的所有锁定，当在一个线程上对象调用stop()方法时，
//这个线程对象所运行的线程就会立即通知.
// 假如一个线程正在执行：
//synchronized void{
//    x= 3;
//    x= 4;
//        }
//这个方法是同步的，多个线程访问时总能保证x,y被同时赋值，
// 而如果一个线程正在执行到x = 3时，被调用了stop()方法，
// 即使在同步快当中，也会马上stop了。  这样产生不了完整的残废数据


//3.使用Thread 类中的一个interrup() 可以中断进程。（）
//interrupt()方法只是改变中断的状态而已，他不会中断一个正在运行的线程，这一方法实际上
//是完成的是，给受阻塞的线程发出一个中断信号，这样受阻塞就得以退出阻塞状态。

//然而interrupt（）方法并不会立即中断操作，具体而言，这个方法只会给线程设置一个
// ture的中断标志（中断标志只是一个布尔类型的变量）,而设置以后，则根据线程当前的
//状态进行不同的后续操作。如果，线程得当前状态处于非阻塞状态，那么仅仅是线程中断标志
//修改位true而已；如果线程当前状态处于阻塞状态，那么在将中断标志设置为true后，还会有
//如下三种情况之一的操作：

//1.如果是wait(),join(),sleep()引起的阻塞，那么会将线程的中断标志设置为false,并
//抛出一个IntreeuptExcaption;

//2.如果在中断时，线程正在处于非阻塞状态，则将中断标志修改为true，而在此基础上,一旦进入阻塞状态
//按照阻塞状态的情况来来进行处理；
//例如，一个线程正在运行状态中，则会立马将标志位设置为true之后，一旦线程调用了wait(),join(),sleep()
//方法中的一种，立马抛出一个InterruptException，且中断标志被程序会自动清除，重设置为false.

//总结:通过上面分析，我们可以总结，调用线程类的interrupted方法，其本质只是设置该线程的中断标志，
//将中断标志设置为true，并根据线程状态决定是否抛出异常。因此，通过interrupt方法真正实现中断的原理是：
//开发人员根据中断标志的具体值，来决定如何退出线程。


//六、线程优先级
//线程的优先级指的是，线程的优先级越高可能先执行，但仅仅是有可能而已

//在Thread类中提供有如下优先级的方法：
//1.设置优先级
//public  final void setPriority(int newPriority);

//2.取得优先级
//public fianal int getPriority()

//对于优先级设置的内容可以设置为
//1.最高优先级：public final static int MAX_PRIORITY = 10;
//2.中等优先级：public final static int NORM_PRIORITY = 5;
//3.最低优先级：public final static int MIN_PRIORITY = 1;


//注意：主线程的优先级是：5  普通优先级。


//7.守护线程
//守护线程是一中特殊的线程，它属于一种陪伴线程。简单点说java中有两种线程：用户线程
//和守护线程。可以通过isDaemon()方法来区别他们；如果返回值是false，则说明该线程
//使“用户线程”；否则就是“守护线程”。典型的守护线程就是垃圾回收线程。只要当前
//JVM进程中存在任何一个非守护线程没有结束，守护线程就在工作；只有当最后一个非守护
//线程结束后，守护线程蔡虎随着JVM一同停止工作。

//线程具有继承性
//线程具有继承关系的，比如当A线程中启动的线程，那么线程B和线程A的优先级是一样的。


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