class PrintName {
    private int flag = 1;
    private int count = 0;

    public int getCount() {
        return count;
    }

    public synchronized void printA() {
        while (flag != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 2;
        count++;
        notifyAll();
    }


    public synchronized void printB() {
        while (flag != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 3;
        count++;
        notifyAll();
    }

    public synchronized void printC() {
        while (flag != 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 1;
        count++;
        notifyAll();
    }

}

class MyThread1 implements Runnable {
    private PrintName printName;

    public MyThread1(PrintName printName) {
        this.printName = printName;
    }

    @Override
    public void run() {
        while (printName.getCount() < 16) {
            if (Thread.currentThread().getName().equals("A")) {
                printName.printA();
            } else if (Thread.currentThread().getName().equals("B")) {
                printName.printB();
            } else if (Thread.currentThread().getName().equals("C")) {
                printName.printC();
            }

        }
    }
}

public class Test2 {
    public static void main(String[] args) {
        PrintName printName = new PrintName();
        MyThread1 mythread = new MyThread1(printName);
        Thread threadA = new Thread(mythread, "A");
        Thread threadB = new Thread(mythread, "B");
        Thread threadC = new Thread(mythread, "C");
        threadA.start();
        threadB.start();
        threadC.start();

    }
}

//class Print {
//    private int flag = 1;
//    private int count = 0;
//
//    public int getCount() {
//        return count;
//    }
//
//    public synchronized void printA() {
//        while (flag != 1) { //不为1，所以打印A的线程等待
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.print(Thread.currentThread().getName());
//        count++;
//        flag = 2;
//        notifyAll();
//    }
//    public synchronized void printB() {
//        while (flag != 2) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.print(Thread.currentThread().getName());
//        flag = 3;
//        count++;
//        notifyAll();
//    }
//    public synchronized void printC() {
//        while (flag != 3) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.print(Thread.currentThread().getName());
//        flag = 1;
//        count++;
//        notifyAll();
//    }
//}
//
//class MyThread implements Runnable {
//    private Print print;
//
//    public MyThread(Print print) {
//        this.print = print;
//    }
//
//    @Override
//    public void run() {
//        while (print.getCount() < 16) {
//            if (Thread.currentThread().getName().equals("A")) {
//                print.printA();
//            } else if (Thread.currentThread().getName().equals("B")) {
//                print.printB();
//            } else if (Thread.currentThread().getName().equals("C")) {
//                print.printC();
//            }
//        }
//    }
//}
//
//
//
//public class Test2 {
//    public static void main(String[] args) {
//        Print print = new Print();
//        MyThread myThread = new MyThread(print);
//        Thread thread1 = new Thread(myThread,"A");
//        Thread thread2 = new Thread(myThread,"B");
//        Thread thread3 = new Thread(myThread,"C");
//        thread1.start();
//        thread2.start();
//        thread3.start();
//    }
//}
