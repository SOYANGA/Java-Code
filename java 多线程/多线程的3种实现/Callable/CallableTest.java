import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("还剩下" + i + "票");
        }
        return "再见";
    }
}

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new MyThread3();  //线程类
        FutureTask<String> futureTask = new FutureTask(callable);  //中转 FutureTask 是runnable的子类    callable ->runnable
        Thread thread1 = new Thread(futureTask);
        thread1.start();
        System.out.println(futureTask.get());
    }
}
