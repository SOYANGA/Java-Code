package ExecutorTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadTest {
    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + "," + j);
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
