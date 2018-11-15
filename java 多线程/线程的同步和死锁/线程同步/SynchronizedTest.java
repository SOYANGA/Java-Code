package ThreadSynchronization;

/**
 * 线程同步与死锁是多线程里面最需要重点理解的概念。这种操作的核心问题
 * 在于：每个线程对象轮番抢占资源带来的问题。
 */
//同步代码块
//第一种方式是在方法里拦截的，也就是说进入到方法中的线程依然可能会有多个。
class MyThread implements Runnable {
    private int ticket = 10; // 一共十张票

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 在同一时刻，只允许一个线程进入代码块处理
            synchronized (this) { // 表示为程序逻辑上锁
                if (this.ticket > 0) { // 还有票
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } // 模拟网络延迟
                    System.out.println(Thread.currentThread().getName() + ",还有" + this.ticket-- + " 张票");
                }
            }
        }
    }
}

class Mythread1 implements Runnable {
    private int ticket = 10; // 一共十张票

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.sale();
        }
    }

    public synchronized void sale() {
        if (this.ticket > 0) {//还有票
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }//模拟网络延迟
            System.out.println(Thread.currentThread().getName() + ",还有" + this.ticket-- + " 张票");
        }
    }
}

class Sync {
    public synchronized void test() {
        System.out.println("test方法开始，当前线程为 " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test方法结束，当前线程为 " + Thread.currentThread().getName());
    }

    //全局锁，代码锁  锁的是类对象
    public void test2() {
        synchronized (Sync.class) {
            System.out.println("test方法开始，当前线程为 " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test方法结束，当前线程为 " + Thread.currentThread().getName());
        }
    }
}

//错误代码  这样无法锁住，因为不是同一个对象
class MyThread2 extends Thread {
    @Override
    public void run() {
        Sync sync = new Sync();
        sync.test2();
    }
}

//修改代码，让其锁同一个对象
class MyThread3 extends Thread {
    private Sync sync;

    public MyThread3(Sync sync) {
        this.sync = sync;
    }

    @Override
    public void run() {
        this.sync.test();
    }
}


public class SynchronizedTest {
    public static void main(String[] args) {
//1.同步代码块
//        MyThread mt = new MyThread();
//        Thread t1 = new Thread(mt, "黄牛A");
//        Thread t2 = new Thread(mt, "黄牛B");
//        Thread t3 = new Thread(mt, "黄牛C");
//        t1.setPriority(Thread.MIN_PRIORITY);
//        t2.setPriority(Thread.MAX_PRIORITY);
//        t3.setPriority(Thread.MAX_PRIORITY);
//        t1.start();
//        t2.start();
//        t3.start();
//2.同步方法
//        Mythread1 mt1 = new Mythread1();
//        Thread t1 = new Thread(mt1, "黄牛A");
//        Thread t2 = new Thread(mt1, "黄牛B");
//        Thread t3 = new Thread(mt1, "黄牛C");
////        t1.setPriority(Thread.MIN_PRIORITY);
////        t2.setPriority(Thread.MAX_PRIORITY);
////        t3.setPriority(Thread.MAX_PRIORITY);
//        t1.start();
//        t2.start();
//        t3.start();

        //3.静态全局锁。（可以锁多个对象  ---其实锁的是对象（class的映射对象））

        //3.1修改代码 ，变为同一个对象
        Sync sync = new Sync();
//        for (int i = 0; i < 3; i++) {
//            Thread thread = new MyThread3(sync);  //同一个对象
//            thread.start();
//        }
        //3.2静态全局锁
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread2();  //多个对象，同一个类
            thread.start();
        }
    }
}
//买票问题：（并发执行）多个线程执行
//三个线程同时买票，由于运行速度快，三个线程可能在同步处理一个
//共享资源时，由于修改++，-- 并非原子性的操作所以，会导致数据不同步
//问题。（本质就是数据更新跟不上数据修改）

//处理这种不同步问题如下：

//一、同步处理
//所谓同步就是让线程不是一起进入到方法中执行，而是一个一个来
//1.1synchronized处理同步问题
//如果要实现这把”锁"的功能，可以采用关键字"synchronized来处理

//synchronized两种模式
//1.1.1使用同步代码块
//如果要使用同步代码块必须设置一个要锁定的对象，所以一般可以锁定当前的对象this
//这种方法只能在方法里面拦截，也就是说进入到方法中的线程依然有多个。

//1.1.2同步方法
//在方法上添加一个关键字 synchronized表示此方法只有一个对象可以进入，
//他有一个隐式的锁对象，this


//同步虽然会保证数据的完整性（线程安全操作），但是其执行速度会很慢，


//2.关于sychronized的额外说明。


//synchronized(this)以及非static 得synchronized方法，只能防止多个进程执行同一个
//对象得同步代码段。即synchronized锁住得是括号里面得对像，而不是代码。对于非static得
//synchroniaed方法，锁得就是对象本身也就是this。

//当synchronized锁住一个对象后，别得线程如果也拿到这个对象得锁，就必须等待这个线程执行完成是方法锁
//才能再次给对象加锁，这样才能达到线程同步得目的。即使两个不同的代码段，都要锁同一个对象，那么这两个
//代码段也不能在多线程环境下同时运行。

//用sychronized锁多个对象
//1.修改代码让其锁同一个对象。  在这个对象上面多创建线程、
//代码如上
//2.锁这个类对应的class对象  （推荐） --全局锁，静态锁。
//代码如上

//synchronized(xxx.class)实现了全局锁的效果。因此，如果想要锁的是代码段，锁住多个对象
//的同一个方法，使用这种全局锁，锁的是类而不是this。
//static synchronized方法，static方法可以直接类名加方法名调用，方法中无法使用this，所以
//它锁的不是this，而是类的class对象，所以，static synchronized方法也相当于全局锁，相当
//锁住了代码段。

