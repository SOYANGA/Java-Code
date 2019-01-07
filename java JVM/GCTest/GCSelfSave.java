package GCTest;

import sun.misc.GC;

public class GCSelfSave {
    public static GCSelfSave test;

    public void isAlive() {
        System.out.println("I am alive:)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        test = this;
    }

    public static void main(String[] args) throws InterruptedException {
        test = new GCSelfSave();
        test = null;
        System.gc();
        Thread.sleep(500);
        if (test != null) {
            test.isAlive();
        } else {
            System.out.println("no ,I am dead:(");
        }
        //--------------下面代码与上面完全一致，但是此次自救失败
        //因为finalize已经被调用一次了
        test = null;
        System.gc();
        Thread.sleep(500);
        if (test != null) {
            test.isAlive();
        } else {
            System.out.println("no ,I am dead:(");
        }
    }
}

//从上面代码示例我们发现，ﬁnalize方法确实被JVM触发，并且对象在被收集前成功逃脱。
//但是从结果上我们发现，两个完全一样的代码片段，结果是一次逃脱成功，一次失败。
// 这是因为，任何一个对象的 ﬁnalize()方法都只会被系统自动调用一次，
// 如果相同的对象在逃脱一次后又面临一次回收，
// 它的ﬁnalize()方法不会 被再次执行，
// 因此第二段代码的自救行动失败。
