/**
 * 内建函数式接口  JDK1.8
 */

import java.io.Console;
import java.util.function.*;


public class InFuncationInterfaceTest {
    public static void main(String[] args) {
        System.out.println("1.功能型函数式接口");
        //功能型接口(String.valueOf)
        Function<Integer, String> fun1 = String::valueOf;
        System.out.println(fun1.apply(1000));
        //确定它要操作的数是int类型的,则可以直接可以使用IntFunction
        IntFunction<String> fun2 = String::valueOf;
        System.out.println(fun2.apply(2000));

        System.out.println("2.供给型函数接口");
        //供给型函数 ("hello",toUpperCase)
        Supplier<String> sup = "hello"::toUpperCase;
        System.out.println(sup.get());

        System.out.println("3.消费型函数接口");
        //消费型函数接口( system.out.println() )
        Consumer<String> cons = System.out::println;
        cons.accept("嘿嘿嘿");

        System.out.println("4.断言型接口");
        Predicate<String> pre = "###123shdbs"::startsWith;
        System.out.println(pre.test("##"));
    }
}
/**
 * Lambda的核心在于：函数式接口。函数式接口的核心：只有一个方法。
 * java.util.funtion
 * 函数式编程分为以下四种接口：
 * 1.功能型函数式接口: public interface Fution<T,R>  R apply<T t>
 * 理解：
 * 功能型指的式你输入一个数据，而后将数据处理后进行处理后进行输出。
 * 实际上所有函数是接口里面都会有一些小的扩展，如果现在确定操作的数据是int，
 * 则可以使用IntFunction接口
 * <p>
 * 2.供给型函数式接口：public interface Supplier     T get();
 * <p>
 * 3.消费型函数式接口：public interface Consumer void accept(T t);
 * <p>
 * 4.断言型接口：public interface Predicate bollean test(T t);
 */
