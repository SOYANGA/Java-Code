@FunctionalInterface
        //注解表示:这是一个函数式编程接口,只允许有一个方法
interface IMessage {
    public void print();//这是一个接口，接口中的抽象方法必须由子覆写
}

interface IMath {
    public int add(int x, int y);
}


public class LambdaTest {
    public static void main(String[] args) {
        //传统面向对象编程的写法(完整)
        IMessage message = new IMessage() {  //使用匿名类覆写
            @Override
            public void print() {  //覆写抽象方法
                System.out.println("Hello World");
            }
        };
        message.print();
        //函数式写法 目的还是实现接口的抽向方法
        //(参数) ->单行语句  为了是实现抽象方法
        IMessage message1 = () -> System.out.println("Hello World");
        message1.print();
        //(参数) ->{} 多行语句 还是为了实现抽象方法.
        IMessage message2 = () -> {
            System.out.println("Hello World");
            System.out.println("Hello World111");
            System.out.println("Hello World11111");
        };
        message2.print();
        //如果现在你的表达式里面只有一行进行数据的放回,
        // 那么直接使用语句即可,可以不使用return
        IMath msg = (p1, p2) -> p1 + p2; //只有一行返回值
        System.out.println(msg.add(10, 20));
        //多行语句需要写return(有返回值的化)
        IMath msg1 = (x, y) -> {
            System.out.println("hahaha");
            return x + y;
        };
    }
}
//函数式编程
//就是简化了传统面向对象的编程。
//面向对象编程有一个最大的局限就是：结构必须完整
//要想使用函数式编程必须要有一个前提：
// 1.接口必须只有一个方法。如果有两个方法，则无法使用函数式编程。
//2.如果现在某个接口就是为了函数式编程而生，
//最好定义时就让其能够定义一个方法，所以有了一个新的注解：

//@FunctionalInterface