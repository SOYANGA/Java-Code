//静态内部类 （static）
//静态内部类与非静态内部类的最大的区别：
//非静态内部类在完成编译后会隐藏地保存着一个引用
//该引用是指向创建它地外围类
//但静态内部类却没有。没有这个引用意味着
//1.静态类地创建是不需要依赖于外部类地，可以直接创建
//2.静态内部类不可以访问外围类地非static成员变量和方法，而成员内部类则都可以
//静态内部类可以拥有static 方法变量，和普通方法，私有变量

class Outter {
    private static String msg = "Hello World";

    static class Inner {// 定义一个内部类
        public void print() { // 此时只能使用外部类中的static 操作
            System.out.println(msg);// 调用msg属性
        }
    }

    // ************************************ */
    // 1.在外部类中定义的一个方法，该方法负责产生内部对象且调用print()方法
    public void fun() {
        Inner in = new Inner();// 内部类对象
        in.print();// 内部类提供的方法
    }
    // ************************************ */
}

// 2.在外部类之外实例化内部类
public class StaticInner {
    public static void main(String[] args) {
        // 2.
        Outter.Inner in = new Outter.Inner();
        in.print();
        // 1.
        // Outter out = new Outter();
        // out.fun();
    }
}