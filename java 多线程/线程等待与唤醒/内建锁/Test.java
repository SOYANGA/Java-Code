package ObjectMethod;
class Mythread implements Runnable {
    private boolean flag;
    private Object object;

    public Mythread(boolean flag, Object object) {
        this.flag = flag;
        this.object = object;
    }


    public void waitMethod() {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "wait begin---------");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "wait end------------");
        }
    }

    public void notifyMethod() {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "notify bgein---------");
            object.notify();
            System.out.println(Thread.currentThread().getName() + "notify end-----------");
        }
    }
    public void print(){
        synchronized (object){
            System.out.println("11111111111111111");
        }

    }

    @Override
    public void run() {
        if (flag) {
            waitMethod();
        } else {
           notifyMethod();
        }
    }
}


public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Mythread mt1 = new Mythread(true, object);
        Mythread mt2 = new Mythread(false, object);

        Thread waitThread = new Thread(mt1, "waitThread1");
        Thread waitThread1 = new Thread(mt1, "waitThread0");

        Thread notifyThraed = new Thread(mt2, "notifyThread");

        waitThread.start();
        waitThread1.start();
        Thread.sleep(1000);
        notifyThraed.start();
    }
}
