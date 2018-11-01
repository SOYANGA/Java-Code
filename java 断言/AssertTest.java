public class AssertTest {
    public static void main(String[] args) {
        int num = 10;
        assert num ==55:"错误：num应当等于55";
        System.out.println(num);
    }
}
//断言assert(了解)
//断言指的是当程序执行到某些语句的之后其数据的内容一定是约定的内容
//必须使用(java - ea)命令行加-ea 参数，启用断言。

