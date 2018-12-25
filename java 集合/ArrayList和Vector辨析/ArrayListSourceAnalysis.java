import java.util.Arrays;

public class ArrayListSourceAnalysis {
    初始化策略：
    public Vector(int initialCapacity, int capacityIncrement) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        this.elementData = new Object[initialCapacity]; //初始化数组
        this.capacityIncrement = capacityIncrement;  //增量（默认是0，即在grow（扩容策略中使用容量扩大2倍策略）
        //如果设置则是按照自己设定的增容策略来进行的
    }

    /**
     * Constructs an empty vector with the specified initial capacity and
     * with its capacity increment equal to zero.
     *
     * @param   initialCapacity   the initial capacity of the vector
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public Vector(int initialCapacity) {
        this(initialCapacity, 0);  //initialCapacity=10 Vector容量
    }

    /**
     * Constructs an empty vector so that its internal data array
     * has size {@code 10} and its standard capacity increment is
     * zero.
     */
    public Vector() {
        this(10); //调用有参构造
    }


    扩容策略：
    public synchronized boolean add(E e) {
        modCount++; //记录数组修改次数
        ensureCapacityHelper(elementCount + 1);
        //确定容量  elementCount：Vector中有效数据长度-即size()
        //初始值为0
        elementData[elementCount++] = e;
        return true;
    }

    public synchronized int size() {
        return elementCount;  //size()
    }

    private void ensureCapacityHelper(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - elementData.length > 0) //elementData.length:初始长度是10
            grow(minCapacity);//增容机制
    }


    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;//2^31-1

    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length; //旧容量
        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                capacityIncrement : oldCapacity)
        //若果在Vector有参构造中设置capacityIncrement(增容策略)，则按照设置的增容策略进行扩容，反之按照扩大原来容量的两倍进行扩容。
        if (newCapacity - minCapacity < 0)//扩容后还是放不下
            newCapacity = minCapacity;//则按照增加后的容量设定数组大小
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity); //同ArrayList
        elementData = Arrays.copyOf(elementData, newCapacity);  //新数组
    }


}
