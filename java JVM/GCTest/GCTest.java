package GCTest;

import java.lang.ref.WeakReference;

public class GCTest {
    private Object instance;
    private static int _1MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _1MB];

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method execute");
        instance = this;
    }

    public static void main(String[] args) {
        GCTest test = new GCTest();
        WeakReference softReference = new WeakReference(test);
        test = null;
        System.gc();
    }
}
