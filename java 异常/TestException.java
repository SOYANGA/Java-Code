public class TestException {
    public static void main(String[] args) throws Exception {//返回个JVM jvm处理：停止程序
        //2.1
        System.out.println("2.1_____________________");
        System.out.println("1.数学计算开始前");
        try {
            System.out.println("2.进行数学计算" + 10 / 0);
        } catch (Exception e) {
            e.printStackTrace(); //对异常信息打打印
        } finally {
            System.out.println("[Finally]不管是否产生异常，都执行此语句");
        }
        System.out.println("3.数学计算结束后");

        //命令行形式异常
        System.out.println("命令行形式异常_________");
        System.out.println("1.数学计算开始前");
        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            System.out.println("[2].进行数学计算：" + x / y);
        } catch (ArithmeticException e) { //被除数为0
            e.printStackTrace();
        } catch (NumberFormatException e) {//用户输入的不是数字:
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {//用户没有输入初始化参数
            e.printStackTrace();
        } finally {
            System.out.println("[Finally]不管是否产生异常，都执行此语句");
        }
        System.out.println("[3].数学计算结束后");

        System.out.println("2.2.1throws方法上返回给调用者______________________");
        //2.2.1

        try {
            System.out.println(calculate(10, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Deal with Exception");


        System.out.println("2.2.1throw方法上返回给用户______________________");
        //2.2.2

        try {
            throw new Exception("抛异常玩玩");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = "100";
        int num = Integer.parseInt(str);  //此方法已经明确抛出异常
        System.out.println(num * 2);


    }

    public static int calculate(int x, int y) throws Exception {  //返回给主方法
        return x / y;
    }
}
//一、异常分类
//父类：Throwable ->子类Erro
//               ->子类Exception 子类->IOException
//                               子类->RuntimeException
//Error:描述Java运行时内部错误与资源耗尽错误。
// 这种内部错误一旦出现，除了告知用户并使程序安全终止之外，
// 再无能无力。这种情况很少出现。

//Exception（程序出错）
// 子类->IOException：程序本身没有问题，
// 由于IO处理导致的程序出错

//子类->RuntimeException：由于程序出错导致的。

//非受查异常（无需强制处理）
//:所有继承Error或RuntimeException的异常类称为非受异常

//受查异常（强制进行处理） 需要用以下2个方法去处理
//:所有继承Exception与IOException的类称为受查异常


//二、异常处理

//2.1 try catch finally(捕捉异常 字定义处理)
//   try {
//         可能出现异常的语句；
//           } [catch] (异常类 对象) {
//           出异常操作；
//           } [finally] {
//                   异常统一出口
//              }
//try ..catch ..
//try .. fianlly..
//try..catch..finallyy..
//ctrl +alt +t:在可能会异常的语句前按组合键
//无论是否产生生异常，无论try catch是否有返回语句，最终都会执行finally语句块
//   e.printStackTrace();对异常信息打打印

//通过cath捕捉处理要确定捕捉异常的类型（可以用父类向上转型接受），或者多写ctch分支

//2.2 throws

//2.2.1throws关键字-作用于方法上（本方法可能会产生异常，返回给调用者处理）
//在进行方法定义的时候，如果要告诉调用者本方法可能产生哪些异常，
// 就可以使用throws方法进行声明。
// 即，如果 该方法出现问题后不希望进行处理，就使用throws抛出
//主方法的调用者：JVM虚拟机

//2.2.2 throw直接编写在语句中，表示人为进行异常的抛出，
// 如果现在异常类对象实例化不希望由JVM产生而由用户产 生，就可以使用throw来完成


//重点：
//1.
//throw 和 throws区别：
//1. throw用于方法内部，主要表示手工异常抛出。
// 2. throws主要在方法声明上使用，明确告诉用户本方法可能产生的异常，
// 同时该方法可能不处理此异常。


//2.RuntimeException类

//package test;
//
//public class Test {
//    public static void main(String[] args) {
//        tring str = "100";
//        int num = Integer.parseInt(str);
//        System.out.println(num * 2);
//    }
//}
//源码定义：
//public static int parseInt(String s) throws NumberFormatException

//A.这个方法上已经明确抛出异常，但是在进行调用的时候发现，即使没有进行异常处理也可以正常执行。
// 这个就属于 RuntimeException的范畴。
//B.很多的代码上都可能出现异常，例如"10/0"都可能产生异常，如果所有可能产生异常的地方都强制性异常处理，这 个代码就太复杂了。所以在异常设计的时候，考虑到一些异常可能是简单问题，所以将这类异常称为 RuntimeException，

// 也就是使用RuntimeException定义的异常类可以不需要强制性进行异常处理。

//面试题：请解释Exception与RuntimeException的区别，请列举几个常见的RuntimeException：

// 1. 使用Exception是RuntimeException的父类，使用Exception定义的异常都要求必须使用异常处理，
// 而使用 RuntimeException定义的异常可以由用户选择性的来进行异常处理。
// 2. 常见的RuntimeException:ClassCastException、NullPointerException等。


























