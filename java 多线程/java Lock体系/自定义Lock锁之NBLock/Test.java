package LockTest;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import static java.lang.Thread.sleep;

class NuBILock implements Lock {
    private Sync sync = new Sync();


    //锁的核心
    static class Sync extends AbstractQueuedSynchronizer {
        //规定同步状态为1
        //无锁为0
        @Override
        protected boolean tryAcquire(int arg) {

            if (arg != 1) {
                throw new RuntimeException("arg不能等于1");
            }
            if (compareAndSetState(0, 1)) {
                //当前线程获取到锁
                setExclusiveOwnerThread(Thread.currentThread());//当前线程传进去
                return true;
            }
            return false;
        }

        //解锁
        @Override
        protected boolean tryRelease(int arg) {
            //判断当前线程是否有锁
            if (getState() == 0) {
                throw new IllegalMonitorStateException();  //假如有锁才让它解锁。
            }
            //当前线程有锁 解锁
            setExclusiveOwnerThread(null);//将当前线程置为空 执行对列
            setState(0);//设置为无锁状态0
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        Condition newCondition() {
            return new ConditionObject();

        }
    }


    //---------------------------------------------
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}


class MyThread implements Runnable {
    private Lock lock = new NuBILock();

    @Override
    public void run() {
        try {
            lock.lock();
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(myThread);
            thread.start();
        }
    }
}
