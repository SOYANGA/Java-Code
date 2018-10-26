//匿名内部类
//没有名字的内部类，没有栈的指向，它符合方法内部类的所有约束，除此之外还有一些地方需要注意：
//1.匿名内部类时没有访问修饰符的
//2.匿名内部类必须继承一个抽象类或者实现一个接口
//3.匿名内部类中不能存在任何静态成员或方法
//4.匿名内部类时没有构造方法的，因为它没有类名
//5.与局部内部类相同的匿名内部类也可以引用方法形参。此形参必须声明为final
interface MyInterface {
    void test();// 只有方法声明 没有方法体（抽象声明）
}// （public abstract）void test(); jaba 中省略请前面的

class Outter {
    private int num;

    public void display(int para) { // 也是final 类型
        // 匿名内部类，实现MyInterface接口
        new MyInterface() { // （class implements 省略 ）类结构

            @Override
            public void test() {
                System.out.println("匿名内部类" + para);
            }
        }.test(); // 匿名一个对象调用它的普通方法test
    }
}

public class AnonymousInner {
    public static void main(String[] args) {
        int num = 20;
        Outter outer = new Outter();
        outer.display(num);
    }
}