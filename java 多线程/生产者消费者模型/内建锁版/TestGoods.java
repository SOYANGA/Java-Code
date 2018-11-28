package ProducerConsumerModel;

import java.util.ArrayList;
import java.util.List;

class Goods {
    private int count;
    private String GoodsName;

    @Override
    public String toString() {
        return "Goods{" +
                "count=" + count +
                ", GoodsName='" + GoodsName + '\'' +
                '}';
    }

    //生产方法
    public synchronized void setGoods(String GoodsName) throws InterruptedException {
        //此时还有消费品没有被消费，等待消费者消费
        while (count > 0) {
            System.out.println("还有商品");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.GoodsName = GoodsName;
        this.count++;
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
        System.out.println("生产" + this);
        System.out.println("-----------------------------");
        //生产完商品后唤醒消费者线程可以消费了
        notifyAll();

    }

    //消费方法
    public synchronized void getGoods() throws InterruptedException {
        //此时还没有商品，等待生产者生产商品
        while (count == 0) {
            System.out.println("还没有生产等一下");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //每次消费一个商品

        this.count--;
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
        System.out.println("消费" + this);
        System.out.println("----------------------------");
        //消费完告生产者线程可以继续生产了
        notifyAll();

    }
}

//生产者
class Producer implements Runnable {
    private Goods goods;
    private String goodsName;

    public Producer(Goods goods, String goodsName) {
        this.goods = goods;
        this.goodsName = goodsName;
    }

    //继续生产
    @Override
    public void run() {
        while (true) {
            try {
                goods.setGoods(goodsName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


//消费者
class Coustom implements Runnable {
    private Goods goods;

    public Coustom(Goods goods) {
        this.goods = goods;

    }

    //继续消费
    @Override
    public void run() {
        while (true) {
            try {
                goods.getGoods();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TestGoods {
    public static void main(String[] args) {
//        Goods goods = new Goods();
        //10个生产者线程
//        Coustom coustom = new Coustom(goods);
//        producer producer = new producer(goods, "哇哈哈");
//        Thread thread1 = new Thread(producer, "生产者线程");
//        Thread thread2 = new Thread(coustom, "消费者线程");
//        thread2.start();
//        thread1.start();

        Goods goods = new Goods();
        List<Thread> threadList = new ArrayList<>();
        //10个生产者线程
        for (int i = 0; i < 10; i++) {
            Thread produceThread = new Thread(new Producer(goods, "娃哈哈"));
            produceThread.setName("生产者线程" + i);
            threadList.add(produceThread);
        }
        //5个消费者线程
        for (int i = 0; i < 5; i++) {
            Thread consumeThread = new Thread(new Coustom(goods));
            consumeThread.setName("消费者线程" + i);
            threadList.add(consumeThread);
        }
        //启动所有线程
        for (Thread thread : threadList) {
            thread.start();
        }
    }
}
