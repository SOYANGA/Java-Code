/*现在要求编写一个方法进行除法操作，但是对于此方法有如下要求：
1. 在进行除法计算操作之前打印一行语句"**".
2. 如果在除法计算过程中出现错误，则应该将异常返回给调用处。
3. 不管最终是否有异常产生，都要求打印一行计算结果信息。
 */


public class Test {
    public static void main(String[] args) {

        try {
            System.out.println(caculate(10, 0));
            System.out.println(caculate1(10, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//对以上优化，进一步简化，直接使用try ...finally
    public static int caculate(int x, int y) throws Exception {
        int result = 0;
        System.out.println("1.[计算开始之前]*************");
        try {
            result = x / y;
        } catch (Exception e) {
            throw e; //抛出去
        } finally {
            System.out.println("2.[计算结束]################");
        }
        return result;
    }

    public static int caculate1(int x, int y) throws Exception {
        int result = 0;
        System.out.println("1.[计算开始前]*****");
        try {
            result = x / y;
        } finally {
            System.out.println("2.[计算结束]#####");
        }
        return result;
    }
}
//对于此时的格式一定要吸收，后面会对此结构进一步优化。（使用代理模式）