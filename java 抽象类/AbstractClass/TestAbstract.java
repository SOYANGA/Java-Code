import com.sun.javafx.runtime.SystemProperties;

// //抽象类的标准用法
// //////////////////////////////////
// abstract class Person { // 抽象类 父类
//     private String name; // 属性

//     public String getName() { // 普通法方法
//         return name;
//     }

//     public abstract void test(); // 抽象方法
// }

// class Student extends Person { // 子类
//     public void test() {
//         System.out.println("子类覆写的抽象方法");
//     }
// }

// public class TestAbstract {
//     public static void main(String[] args) {
//         Person per = new Student(); // 实例化子类 向上转型
//         per.test(); // 子类所覆盖得到方法
//     }
// }

////////////////////////////////////////
// 封装具体子类--不属于开发首选
//非正常模式，但对一些封装又一定的好处（封装具体子类），不属于开发的首选
// abstract class Person {
//     private String name;// 属性

//     public String getName() { // 普通方法
//         return this.name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     // {}为方法 所有抽象方法上不包含方法体
//     public abstract void getPersonInfo(); // 抽象方法
//     // 静态方法 方法内部类 且方法内部类继承外部抽象类

//     public static Person getInstance() { // 取得子类对象
//         class Student extends Person { // 定义抽象类的子类 （方法内部类）
//             public void getPersonInfo() {
//                 System.out.println("I am a student");
//             }
//         }
//         return new Student();
//     }
// }

// public class TestAbstract {
//     public static void main(String[] args) {
//         Person per = Person.getInstance();
//         per.getPersonInfo(); // 被子类覆写的方法
//     }
// }

////////////////////////
// 抽象类相关约定
//1.抽象类中定义构造反法 -先调用父类的构造方法 然后再调用子类构造方法
// abstract class Person {
//     private String name;// 属性

//     public Person() {// 钩子方法
//         System.out.println("**********");
//     }

//     public String getName() {
//         return this.name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     // {}为方法体，所有抽象方法上不包含方法体
//     public abstract void getPersonInfo();// 抽象方法
// }

// class Student extends Person {
//     public Student() { // 无参构造
//         System.out.println("#################");
//     }

//     public void getPersonInfo() {

//     }
// }

// public class TestAbstract {
//     public static void main(String[] args) {
//         new Student();
//     }
// }
////////////////////
//1.1一段特殊的
// abstract class A {
//     public A() { // 3.调用父类构造方法
//         this.print(); // 4.调用被子类覆写方法
//     }

//     public abstract void print();// .抽象方法
// }

// class B extends A {
//     private int num = 100;

//     public B(int num) { // 2.调用子类实例化对象
//         super(); // 3.隐藏了一行语句，实际要先调用父类构造
//         this.num = num;//7.为类属性初始化
//     }

//     public void print() {// 此时子类对象的属性还没有初始化
//         System.out.println(this.num);// 6.对应其数据类型的默认值（num 此时还是默认值 0）
//     }
// }

// public class TestAbstract {
//     public static void main(String[] args) {
//         A a = new B(30);// 1子类实例化子类对象
//         //0
//         a.print();     //8.调用被子类覆写的抽方法的print  //此时子类的对象属性已经初始化完毕 已经有赋值完为3.
//         //30
//     }
// }
//抽象类中允许不定义任何的抽象方法，但此时抽象类依然无法直接创建实例化对象
// abstract class A {
//     public void print() {
//         // 空实现
//     }

// }

// public class TestAbstract {

//     public static void main(String[] args) {
//         A a = new a(); // 错误 A是抽象的，无法实例化
//     }
// }
/////////////
//
//1.2.3抽象类一定不能使用final声明 ，因为final声明的类不允许有子类;而抽象类必须有子类，抽先方法也不能使用private定义
//因为抽象方法是必须要覆写的。
//1.2.4
//抽象类也分为内部抽象类，内部抽象类中也可以使用static 定义来描述外部抽象类
//内部抽象类： 抽象类继承时 继承谁就覆写谁的方法 ，内部抽象类子类的，必须要被继承外部类的内部类覆写
// abstract class A { // 此类结构出现得几率很低
//     public abstract void printA();

//     abstract class B {
//         public abstract void printB();
//     }

// }

// class X extends A {
//     public void printA() {
//         System.out.println("I am A");
//     }

//     class Y extends B {
//         public void printB() {
//             System.out.println("I am B");
//         }
//     }
// }

// public class TestAbstract {
//     public static void main(String[] args) {
//         X.Y x = new X().new Y();
//         new X().printA();
//         x.printB();

//     }
// }

// 如果现在外部抽象类中使用了 static 那么语法错误，但是内部抽象类允许使用static
// 范围：内部抽象类使用static 修饰
abstract class A {

    public abstract void printA();

    static abstract class B {
        public abstract void printB();
    }
}

class X extends A.B {
    public void printA() {
        System.out.println("I am A");
    }

    public void printB() {
        System.out.println("I am B");
    }
}

public class TestAbstract {
    public static void main(String[] args) {
        X x = new X();
        x.printB();
        new X().printA();

    }
}
