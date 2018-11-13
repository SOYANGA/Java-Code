/**
 * JDK1.5开始追加了新的开发包  -----------唯一个有返回值得线程实现方式
 * JUC java.util.cincurrent：这个开发包主要是进行高并发编程使用的，包含很多在高并发
 * 操作中会使用的类。这个包中定义有一个全新的接口Callable。
 * <p>
 * Callable 实现Call方法
 * <p>
 * 其返回值用java.util.Future<V>:  取得call方法得返回值
 * V get( )throws InterruptedException, ExecutionException
 */
package Multiprocess;

import sun.security.krb5.internal.ccache.CCacheInputStream;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//
//class MyThread3 implements Callable<String> {
//    @Override
//    public String call() throws Exception {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("还剩下" + i + "票");
//        }
//        return "再见";
//    }
//}
//
//public class CallableTest {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Callable<String> callable = new MyThread3();  //线程类
//        FutureTask<String> futureTask = new FutureTask(callable);  //中转 FutureTask 是runnable的子类    callable ->runnable
//        Thread thread1 = new Thread(futureTask);
//        thread1.start();
//        System.out.println(futureTask.get());
//    }
//}

class MyThread3 implements Callable<String> {//返回值类类型
    private int ticket = 10;

    @Override
    public String call() throws Exception {
        while (this.ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "剩余票数" + this.ticket--);
        }
        return "票卖完了！";
    }
}

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new MyThread3();
        FutureTask<String> futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask, "dadad");
        Thread thread1 = new Thread(futureTask, "haha");
        thread1.start();
        thread.start(); //有疑问？先执行线程就会独享资源
        System.out.println(futureTask.get());

        //        FutureTask<String> futureTask = new FutureTask(new MyThread3());
//        new Thread(futureTask).start();
//        new Thread(futureTask).start(); //有疑问？
//        System.out.println(futureTask.get());

    }
}


//------------唯一个有返回值得线程实现方式
//不管何种情况。如果要想启动多线程只有Thread类中的start()方法。
//所以无论如何我们都必须将 线程类转换为Threadl类

//Callable的继承树

//取得call()方法的返回值用Future接口的 <V>get方法

//RunableFuture既是 Future接口的字接口又是Runnable接口的子接口/
//且Runbale有子类Thread类
//RunnableFuture有子类FutureTask类

//Thread类 和 FutureTask类拥有共同的父类，且Runnable可以通过Thread类的构造方法变为Thread类
// 则FutureTask类也可以通过Thread类的构造方法变为Thread类
//进而调用Thread类的start()方法启动线程。

//最关键的是 Callable可以通过FutureTask类的构造方法变为Futuretask类