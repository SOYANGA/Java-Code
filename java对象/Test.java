import java.awt.SystemTray;

// class Person {
//     { // 定义在类中，不加任何修饰符，构造块
//         System.out.println("1.Person类的构造块");
//     }

//     public Person() {
//         System.out.println("2.Person类的构造方法");
//     }

//     static { // 定义在非主类中的静态块
//         System.out.println("3.Person类的静态块");
//     }
// }

// public class Test {
//     public static void main(String[] args) {
//         System.out.println("4.--start--");
//         new Person();
//         new Person();
//         System.out.println("5.--end--");
//     }
// }
// class Outer {   //外部类
//     private String msg = "hello,world";

//     public String getMsg() { // 10.get msg属性
//         System.out.println("尝试");
//         return this.msg;
//     }

//     public void fun() {// 3.对象out调用fun方法
//         Inner in = new Inner(this);// 4.实例化Inner对象，并且构造参数为out引用传递
//         in.print(); // 7.调用in 对象的print方法
//     }
// }

// class Inner {//内部类
//     private Outer out; // 创建一个私有的属性 （out对象栈中）

//     public Inner(Outer out) { // 5.有参数构造 接受out对象（栈中间）
//         this.out = out; // 6.让 in创建的out对象等于，Outer类中的out对象（即指向堆内存中的属性相同）
//     }

//     public void print() { // 8.print方法
//         System.out.println(out.getMsg()); // 9.调用Outer中的getMsg 且打印
//     }
// }

// public class Test {
//     public static void main(String[] args) {
//         Outer out = new Outer(); // 1.实例化Outer对象
//         out.fun(); // 2.调用Outer方法
//     }
// }

//内部类直接实例化 再调用外部类的私有属性
// -----------------------------------------------
// class Outer {// 外部类
//     private String msg = "hello,world";

//     public String getMsg() { // 10.get msg属性
//         System.out.println("尝试");
//         return this.msg;
//     }

//     // public void fun(){//3.对象out调用fun方法
//     // // Inner in =new Inner(this);//4.实例化Inner对象，并且构造参数为out引用传递
//     // // in.print(); //7.调用in 对象的print方法
//     // }

//     class Inner {// 内部类
//         // private Outer out; //创建一个私有的属性 （out对象栈中）
//         // public Inner(Outer out){ //5.有参数构造 接受out对象（栈中间）
//         // this.out =out; //6.让 in创建的out对象等于，Outer类中的out对象（即指向堆内存中的属性相同）
//         // }
//         public void print() { // 8.print方法
//             System.out.println(Outer.this.getMsg()); // 9.调用Outer中的getMsg 且打印
//         }
//     }
// }

// public class Test {
//     public static void main(String[] args) {
//         Outer.Inner in = new Outer().new Inner();
//         // Outer out = new Outer(); //1.实例化Outer对象
//         in.print(); // 2.调用Outer方法
//     }
// }

///////////////////////////////
//static 定义的内部类 只能调用 外部类的static 属性及方法
// class Outer {
//     private static String msg = "hello world";

//     // *************************
//     static class Inner { // static 定义一个内部类
//         public void print() { // 只能使用内部类中static 操作
//             System.out.println(msg);// 调用 msg属性
//         }
//     }

//     // *******************************
//     // 在外部类中定义一个方法，该方法负责产啥呢个内部类对象并且调用print（）方法
//     public void fun() {
//         Inner in = new Inner();
//         in.print();
//     }
// }

// public class Test {
//     public static void main(String[] args) {
//         // 1.内部类实例化
//         // Outer.Inner in=new Outer.Inner();
//         // in.print();
//         // 2.调用外部类实例化内部类
//         Outer out = new Outer();
//         out.fun();
//     }
// }
//-----------------------------------------
// 在方法中定义类
class Outer {
    public static String msg = "Hello world";

    public void fun(int num) {
        class Inner {
            public void print() {
                System.out.println("num:" + num);
                System.out.println("msg:" + msg);
            }
        }
        new Inner().print();
    }
}

public class Test {
    public static void main(String[] args) {
        Outer out = new Outer();
        out.fun(55);
    }
}