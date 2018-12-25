import java.util.Arrays;

public class VectorySourceAnalysis {
    public boolean add(E e) { //添加元素
        ensureCapacityInternal(size + 1);  // Increments modCount!! //size=0（在源码中未初始化）
        elementData[size++] = e;
        return true;  //只会返回true方法，要么就回报错（异常）
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    private static int calculateCapacity(Object[] elementData,int minCapacity)
    {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {//为空数组
            return Math.max(DEFAULT_CAPACITY, minCapacity); //取两个数之中的最大值  minCapacity  (size+1)=1
        }
        return minCapacity; // 返回1
    }
    //private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    //DEFAULTCAPACITY_EMPTY_ELEMENTDATA 为空数组

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;  //记录数组修改次数

        // overflow-conscious code  //超出数组当前容量（懒加载策略）
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);  //扩容方法
    }

    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length; //记录旧容量
        int newCapacity = oldCapacity + (oldCapacity >> 1);//新容量 = 1.5旧容量
        if (newCapacity - minCapacity < 0) //开辟完后还是放下增加的元素
            newCapacity = minCapacity; //直接将需要的容量在数组上开辟
        if (newCapacity - MAX_ARRAY_SIZE > 0) //如果新容量大于这个数
            newCapacity = hugeCapacity(minCapacity);
        //就将Integer.MAX_VALUE（integer最大值）赋给新容量
        //看不懂这是在干什么？是要采取覆盖策略吗？
        // minCapacity is usually close to size, so this is a win: 要设定的容量往往接近size值所以是一个双赢？双赢在哪里
        elementData = Arrays.copyOf(elementData, newCapacity);//新数组
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    //为什么设置了这个值？

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError(); //超出integer最大值异常
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE ://2^31-1
                MAX_ARRAY_SIZE;//2^31-1-8
    }

    //重点：
    int newCapacity = oldCapacity + (oldCapacity >> 1);//新容量 = 1.5旧容量

}
