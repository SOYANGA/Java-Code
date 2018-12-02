package Multiprocess;
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

//        thread.run();    //相当与普通方法，与多线程无关//串行执行




    }
}
//每个线程对象只能启动一次 否则会抛出 IllegalThreadStateException(非受查异常)
//-----------------------------------------
//start（）方法调用了start0（）方法，而这个方法只是一个声明而未实现方法同时使用native
//关键字进行了定义。本地方法（c语言实现）调用的式本机原声系统函数

//Thread有一个registerNatives本地方法，该方法主要作用就是注册一些本地方法共Thread类
//使用，如start0() stop0()等，可以说操作本地线程的本地方法都是由他注册的。
//这个放啊在一个static语句块当中，该类被加载到JVM中的时候，他就会被调用，进而注册相应的本地方。
//而本地方registerNative是定义在Thread.c文件大当中的。Thread.c是一个很小的文件，他
//定义了各个操作系统平台都要用到的关于线程的公用数据和操作。

//调用了start ->start0()->JVM_StartThread方法，这个方法最终调用了Java线程的run方法

//JVM_EnTRY是一个宏，用来定义JVM_StartThread函数，可以看出函数内建立了真正的平台相关的本地线程
//其线程函数是thread_entry
//可以看到调用了 vmSymbolHandles::run_method_name 方法，
// 而run_method_name是在 vmSymbols.hpp 用宏定义的： 就是引用了 ru()。
//------------------------------

//总结：
//run（）方法相当与线程的入口。
//实际上我们调用了start()方法就是间接的调用了run()方法
//只是调用run()方法不是我们而是由JVM调用的，保护资源的利用（不能让我们直接队内存资源进行直接调用，比如启动一个线程）
//
