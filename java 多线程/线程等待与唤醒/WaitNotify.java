package ObjectMethod;

import javax.swing.plaf.synth.SynthRadioButtonUI;

/**
 * 并发工具类 wait() 和 notify()方法
 * 生产消费者不直接通信，而是通过阻塞队列来进行通信，所以生产着者生产完数据后就不用等消费者处理，
 * 直接扔到阻塞队列，消费者不用找生产者索要数据，而是直接从阻塞队列里取，阻塞队列就相当于一个缓冲区，平衡了生产者
 * 和消费者的处理能力。
 * <p>
 * 阻塞队列就相当于生产者和消费者之间的解耦者。
 */
class MyThread1 implements Runnable {
    private boolean flag;
    private Object object;

    public MyThread1(boolean flag, Object object) {
        super();
        this.flag = flag;
        this.object = object;
    }

    public void waitMethod() {
        synchronized (object) {
            try {
                while (true) {
                    System.out.println("wait()方法开始---------" + Thread.currentThread().getName());
                    object.wait();
                    System.out.println("wait()方法结束---------" + Thread.currentThread().getName());
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void notifyMethod() {
        synchronized (object) {
            System.out.println("notifyAll()方法开始.. " + Thread.currentThread().getName());
            object.notifyAll();
            System.out.println("notifyAll()方法结束.. " + Thread.currentThread().getName());
        }
    }


    @Override
    public void run() {
        if (flag) {
            this.waitMethod();
        } else {
            this.notifyMethod();
        }
    }
}


public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        MyThread1 waitThread1 = new MyThread1(true, object);
        MyThread1 waitThread2 = new MyThread1(true, object);
        MyThread1 waitThread3 = new MyThread1(true, object);
        MyThread1 notifyAllThrad = new MyThread1(false, object);
        Thread thread = new Thread(waitThread1, "wait线程A");
        Thread thread2 = new Thread(waitThread2, "wait线程B");
        Thread thread3 = new Thread(waitThread3, "wait线程C");
        Thread thread4 = new Thread(notifyAllThrad, "notifyAll线程");
        thread.start();
        thread2.start();
        thread3.start();
        Thread.sleep(1000);
        thread4.start();
        Thread.sleep(1000);
        System.out.println("main方法结束!!");
    }
}
/*
 一、wait()与notify()方法

 1.1 wait()方法:让线程停止运行
 I.方法wiat()的作用时使当前执行代码的线程进行等待,wait()方法是Object类的方法,
 该方法是用来将当前线程置入"与执行队列中",并且wait()所处的代码处停止执行,
 直到接到通知或被中断为止.

 II.wait()方法只能用在同步队列中或同步方法中调用.如果调用wait()时,没有持有适当的锁
 则会抛出异常。

 III.wait()方法执行后，当前线程释放锁，线程与其他线程竞争重新获得锁。

 1.2 notify()：就是使线程继续运行下去

 I.方法notify()也要在同步方法或同步块中调用，该方法是用来通知那些等待该对象的对象锁的其他线程，
 对其他发出通知notify,并使它们重新获得该对象的对象锁。如果有多个线程等待，
 则有线程规划器随机挑选出一个呈wait状态的线程。

 JDK1.8是从等待队列的头部开始唤醒（出队列）

 II.在nitify()方法后，当前线程不会马上释放对象锁，等到执行notify()方法的线程程序执行完毕的时候
 也就是退出同步代码块的时候才会释放锁。

1.3notifyAll()方法
一次唤醒所有等待线程。
JDK1.8是从队尾到队头唤醒的。
注意唤醒的时机。

1.4出现阻塞的请款大体分为如下五种

1.线程调用sleep()方法，主动放弃占用处理器资源。
2.线程调用了阻塞式IO方法，在该方法返回前，该线程被阻塞。
3.线程试图获得一个同步监视器，但该同步监视器正在被其他线程所持有。
4.线程等待某个通知
5.程序调用了suspend()方法将该线程挂起，此方法容易导致死锁尽量避免使用该方法。

run()方法运行结束后进入销毁阶段，整个线程执行完毕。
每个锁对象都有两个队列，一个是就绪队列，一个是阻塞队列。就绪队列储存了将要获得锁的线程，阻塞
队列存储了被阻塞的线程。一个线程被唤醒后，才会进入就绪队列，等待CPU的调度，一个线程被唤醒后，
才会进入就绪队列，等待CPU的调度；反之，一个线程被wait后，就会进入阻塞队列，等待下一次被唤醒。




 */
