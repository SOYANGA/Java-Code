package ExecutorTest;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


import static java.lang.Thread.sleep;

class RunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "," + i);
        }
    }
}

class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            sleep(3000);
            System.out.println(Thread.currentThread().getName() + "," + i);
        }
        return Thread.currentThread().getName() + "任务执行完毕";
    }
}

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //execute（）方法
        RunnableThread runnableThread = new RunnableThread();
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(3, 5, 2000, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>());
        ArrayList<Runnable> list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            threadPoolExecutor.execute(runnableThread);
        }
        list = (ArrayList<Runnable>) threadPoolExecutor.shutdownNow();
        sleep(1000);
        for (Runnable i : list) {
            System.out.println(i + ",");
        }
        System.out.println(list.size());

        //sbumit方法
//        CallableThread callableThread = new CallableThread();
//        ThreadPoolExecutor threadPoolExecutor1 =
//                new ThreadPoolExecutor(3, 5, 2000, TimeUnit.MILLISECONDS,
//                        new LinkedBlockingQueue<Runnable>());
//        for (int i = 0; i < 5; i++) {
//            Future<String> future = threadPoolExecutor1.submit(callableThread);
//            String str = null;
//            try {
//                str = future.get();
//                System.out.println(str);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
        threadPoolExecutor.shutdown();
    }
}

