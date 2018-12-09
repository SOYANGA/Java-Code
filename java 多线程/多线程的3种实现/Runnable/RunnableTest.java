package Multiprocess;

/**
 * 通过Runnable接口实现多线程
 * Thread类的核心功能时进行线程启动。
 * 如果一个类为了实现多线程而去继承Thread类就会由单继承局限。
 * 避免单继承局限
 * Runnable接口是Thread类 的父接口 。Thread 实现了Runnable接口的run（）抽象方法。
 * 在java中由提供另一种实现的模式：Runnable接口。
 */
//1.普通方法
class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World");
    }
}


public class RunnableTest {
    public static void main(String[] args) {
        System.out.println("1.普通方法————————————————");
        MyThread mt = new MyThread();
        Thread thread1 = new Thread(mt, "线程A");
        Thread thread2 = new Thread(mt, "线程B");
        Thread thread3 = new Thread(mt, "线程c");
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("2.匿名内部类————————————————");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hi World!");
            }
        }).start();
        System.out.println("3.Lambda 表达式——————————————-");
        Runnable runnable = () -> System.out.println("HAHA World!");
        new Thread(runnable).start();

    }
}

//观察源码发现 Runnable接口是Thread类的父接口，
//接口中声明了run（）方法所以我们需要继承接口Runnable
// 并实现他的方法run()方法。
//但是真正我们可以启动一个线程的方法只有start（）方法，该方法只有Thread类（线程的核心类）
//所以我们要实现多线程必须转换为Thread类
//Runnable->Thread    通过Thread的构造方法可以传入一个Runnable对象作为参数
//然后用转变为Thread 对象调用start()方法。-启动线程的永远都是Thread类的start()方法

//可以用匿名内部类或者Lambda表达式来定义 Runnable接口对象，并实现它的run()方法


//线程执行顺序不是由我们预想的那样，按顺序执行，这个执行需要依照操作系统进行调度的。

//操作系统分给每个线程的时间片很短，让我们感觉是在同步执行。
//”同步执行“：其实是不停切换执行线程。


//Runnable与Thread 区别：
//is -a关系  Thread类实现run()方法。
//Runnable可以更好的描述共享资源。

//多线程处理上其实就是使用的代理模式：
//Thread是代理

//MyThread是核心业务处理者。
