//内部类可以实现Java的单继承局限
//内部类可以对同一包中的其他类进行隐藏，仅供外部类使用（保护性）
class A {
    private String name = "A类的私有域";

    public String getName() {
        return name;
    }
}

class B {
    private String name = "B类的私有域";

    public String getName() {
        return name;
    }
}

class Outter {
    // 内部类可以对同一包中的其他类进行隐藏，仅供外部类使用（保护性）
    private class InnerClassA extends A { // 私有内部类继承A类
        // public String name() {
        // return super.getName();
        // }
    }

    // 内部类可以对同一包中的其他类进行隐藏，仅供外部类使用（保护性）
    private class InnerClassB extends B { // 私有内部类继承B类
        // public String name() {
        // return super.getName();
        // }
    }

    public String name1() {
        // 内部类可以对同一包中的其他类进行隐藏，仅供外部类使用（保护性）
        return new InnerClassA().getName(); // 必须在外部类中实例化私有内部类 
    }

    public String name2() {
        // 内部类可以对同一包中的其他类进行隐藏，仅供外部类使用（保护性）
        return new InnerClassB().getName();// 必须在外部类中实例化私有内部类
    }
}

public class TestInner23 {
    public static void main(String[] args) {
        Outter outter = new Outter();
        System.out.println(outter.name1());
        System.out.println(outter.name2());
    }
}

//总结
//1.通过外部类创建了多个内部类并分别继承多个父类
//来实现“多继承” ：即外部类继承了两个类，但其实是外部类的多个内部类，分别继承两个父类

//2.内部类可以对同一包中的其他类进行隐藏，仅供外部类使用（保护性）
//即：在外部类中创建的用private 修饰的内部类是只对外部类可见的，对其他类不可见
//达到讲其保护起来（隐藏起来的功能）