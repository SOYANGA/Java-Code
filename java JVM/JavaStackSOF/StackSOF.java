package JavaStackSOF;


/**
 * JVM参数为：-Xss128k
 */
public class StackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();//递归调用
    }

    public static void main(String[] args) {
        StackSOF test = new StackSOF();
        try {
            test.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack Length:" + test.stackLength);
            throw e;
        }
    }
}
