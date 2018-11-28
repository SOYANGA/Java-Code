import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Goods {
    private final int maxCount;
    private String name;
    private int count;
    private Lock lock = new ReentrantLock();
    private Condition producerCondition = lock.newCondition();
    private Condition comstomCondition = lock.newCondition();

    public Goods(int maxCount) {
        this.maxCount = maxCount;
    }

    public void setGoods(String name) {
        lock.lock();
        try {
            while (count == maxCount) {
                System.out.println("商品数量已达大，等待消费者消费");
                producerCondition.await();
            }
            Thread.sleep(200);
            this.name = name;
            //生产消费者
            count++;
            System.out.println(Thread.currentThread().getName() + "生产" + toString());
            comstomCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void getGoods() {
        lock.lock();
        try {
            while (count == 0) {
                System.out.println("商品还没有准备好，客观请等一下！");
                comstomCondition.await();
            }
            Thread.sleep(200);
            //消费生产者线程
            count--;
            System.out.println(Thread.currentThread().getName() + "消费" + toString());
            producerCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Goods{" + "name='" + name + '\'' + ", count=" + count + '}';
    }
}

class Comstom implements Runnable {
    private Goods goods;

    public Comstom(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            this.goods.getGoods();
        }
    }
}

class Producer implements Runnable {
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            this.goods.setGoods("娃哈哈");
        }
    }
}


public class ConditionProducerConsumer {
    public static void main(String[] args) {
        Goods goods = new Goods(50);
        List<Thread> list = new ArrayList<>();
        Producer producer = new Producer(goods);
        Comstom comstom = new Comstom(goods);
        //创建10个消费者线程
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(comstom, "消费者" + i);
            list.add(thread);
        }
        //创建个生产者线程
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(producer, "生产者" + i);
            list.add(thread);
        }
        for (Thread thread : list) {
            thread.start();
        }

    }
}
