//方法内部类 （局部类）
//只能在外内部类的方法中使用，出了方法失效
//与成员内部类基本一致主要是作用域不同

//1.对于方法内部类（非静态内部类），内部类的创建依赖外部类的实例对象，在没有外部类实例化之前是无法创建内部类的
//只能在方法中实例化局部内部类    
//2.方法内部类不能存在任何static变量或者方法。但可以访问外部类的static方法，自己不能拥有
//假如拥有，则会编译报错  
//3.内部类是一个相对独立的实体，与外部类不是is-a（继承关系）
//4.方法内部类可以直接访问外部类的元素（包括私有域），但外部类只能 在定义在内部类的方法中 直接访问内部类的元素
//5.外部类可以通过内部类的间接引用访问内部类的元素
//6.内部类不能用访问权限修饰符 （多此一举）
//7.方法内部类（局部内部类）想要使用方法的形参 ，该形参必须用finnal声明(JDK 8形参变为隐式声明)
class Outter {
    private static int num;// 外部类私静态有属性

    public void display(int test) { // 实例化内部类的方法
        class Inner { // 方法内部类
            private int nums = 10; // 内部类私有属性

            private void fun() {
                num++; // 直接访问外部类私有属性
                Outter.num = 99; // 内部类可以访问外部类静态属性
                System.out.println(num);
                System.out.println(test); // 参数必须是final 类型。（隐式参数）
            }
        }
        Inner in = new Inner(); // 实例化内部类
        // new Inner().fun();
        in.fun(); // 调用内部类的方法
        System.out.println(in.nums); // 直接访问方法内部类的私有属性
    }
}

public class MethodInner {
    public static void main(String[] args) {
        int i = 0; // 没有权限修饰的属性
        i = 100; //
        Outter out = new Outter();
        out.display(i); // 当传入参数时就给参数隐式的变成了final类型
    }
}