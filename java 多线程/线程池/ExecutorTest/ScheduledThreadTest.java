package ExecutorTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ScheduledThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService =
                Executors.newScheduledThreadPool(5);
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            executorService.schedule(new Runnable() {
                @Override
                public void run() {

                    for (int j = 0; j < 1000; j++) {
                        System.out.println(Thread.currentThread().getName() + "," + j);
                    }
                }
            }, 8,  TimeUnit.SECONDS);
        }
//        sleep(10002);  // ?调度池在延迟期间主线程也在一直运行 为什么不执行关闭线程池的方法
        executorService.shutdown();
    }
}
