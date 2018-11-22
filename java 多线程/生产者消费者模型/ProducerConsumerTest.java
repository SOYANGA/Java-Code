package ProducerConsumerModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者与消费者一般需要第三方来解耦的，所以线程就模拟一个简单的商品的生产者和消费者，
 * 由生产者线程生产一个商品后将由消费者开始消费。
 * 由控制商品数量来确定什么时候唤醒和阻塞
 * 商品类作为解耦者，要有其生产和消费方法。
 */
class Goods1 {
    //商品名称
    private String goodsName;
    //商品库存
    private int count;

    //生产方法
    public synchronized void setGoods(String goodsName) throws InterruptedException {
        //此时商品还没有消费完，等待消费者消费
        while (this.count > 0) {
            System.out.println("还有库存,等待消费者");
            wait();
        }
        this.goodsName = goodsName;
        this.count++;
        Thread.sleep(1000);
        System.out.println("生产" + this);
        System.out.println("============================================");
        //生产者生产完后唤醒消费者线程，让它去消费
        notifyAll();
    }

    public synchronized void getGoods() throws InterruptedException {
        //此时还没有商品被生产，等待生产者生产
        while (this.count == 0) {
            System.out.println("商品卖完了，客观等一下哦。。");
            wait();
        }
        //每次消费一个商品
        this.count--;
        Thread.sleep(1000);
        System.out.println("消费" + this);
        //消费完告知生产者线程可以继续生产了
        notifyAll();
    }

    @Override
    public String toString() {
        return "Goods [goodsName=" + goodsName + ", 库存为" + count + "]";
    }
}

class Producer1 implements Runnable {
    private Goods1 goods;

    public Producer1(Goods1 goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.goods.setGoods("哇哈哈");
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}

class Consumer1 implements Runnable {
    private Goods1 goods;

    public Consumer1(Goods1 goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.goods.getGoods();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}


public class ProducerConsumerTest {
    public static void main(String[] args) {
        Goods1 goods = new Goods1();
//        Thread producerThrad1 = new Thread(new Producer1(goods), "生产者线程");
//        Thread comsumerThrad1 = new Thread(new Consumer1(goods), "消费者线程");
//        //启动消费者线程
//        comsumerThrad1.start();
//        //启动生产者线程
//        producerThrad1.start();
        // 存储生产、消费者线程
        List<Thread> threadList = new ArrayList<>();
        // 10个生产者线程

        for (int i = 0; i < 10; i++) {
            Thread produceThread1 = new Thread(new Producer1(goods));
            produceThread1.setName("生产者线程 " + i);
            threadList.add(produceThread1);
        }
        // 6个消费者线程
        for (int i = 0; i < 6; i++) {
            Thread consumeThread1 = new Thread(new Consumer1(goods));
            consumeThread1.setName("消费者线程 " + i);
            threadList.add(consumeThread1);
        }
        // 启动所有线程
        for (Thread thread : threadList) {
            thread.start();
        }

    }
}
