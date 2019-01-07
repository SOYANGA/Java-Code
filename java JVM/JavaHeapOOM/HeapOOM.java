package JavaHeapOOM;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM参数：-Xmx20m -Xms20m -xx: +HeapDumponoutofMemoryError
 */

public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());//内存泄漏
        }
    }
}

//Java堆内存的OOM异常是实际应用中常见的内存溢出情况。当出现Java堆内存溢出时，
//异常堆栈信 息"java.lang.OutOfMemoryError"会进一步提示"Java heap space"。
//当出现"Java heap space"则很明确的告知我 们，OOM发生在堆上。
//此时要对Dump出来的文件进行分析，以MAT为例。
// 分析问题的产生到底是出现了内存泄漏(Memory Leak)还是内 存溢出(Memory Overﬂow)
//内存泄漏 : 泄漏对象无法被GC
// 内存溢出 : 内存对象确实还应该存活。
// 此时要根据JVM堆参数与物理内存相比较检查是否还应该把JVM堆内存调 大；或者检查对象的生命周期是否过长。
