//接口 前面加I eg:IMYInterFace
//接口的实例化必须向上转型
// interface IMyInterFace {
//     // 全局常量  
//     public static final String msg = "I am a biter";

//     // 抽象方法 public
//     public abstract void print();
// }

// interface INews {
//     public abstract String getNews();
// }

// // 子接口 后面加上 Imple eg:MYInterfaceImpl
// class MyInterfaceImpl implements IMyInterFace, INews {
//     public void print() {
//         System.out.println(IMyInterFace.msg);
//     }

//     public String getNews() {
//         return IMyInterFace.msg; // 访问常量属性建议加上类名称
//     }

// }

// // new 的子类才有意义，别被前面的类名搞晕了
// class Interface {
//     public static void main(String[] args) {
//         IMyInterFace m = new MyInterfaceImpl();// 子类向上转型，为父接口实例化对象
//         m.print(); // 调用被子类覆写过的方法
//         INews n = (INews) m; // 多继承之间的转换
//         System.out.println(n.getNews());// 调用被子类覆写过得方法
//     }
// }

//////////////////////////////////////////////////////////////////////
// 1.接口只允许public 权限。（不管是属性还是方法，其权限是public）
// 在以后编写接口的时候，99的接口都只提供抽象方法，很少有接口里提供全局常量
//2. 阿里编码规约：接口中的方法和属性不要加任何修饰符号public也不要加，保持代码的简洁性
// 3.且当一个子类急需要实现接口又需要继承抽象类时，
//请先使用extends继承一个抽象类，而后使用 implenents 实现多接口
//4.有共同子类（子接口）的类可以通过此类相互转换 

// interface IMessage {
//     void print(); // 不用任何修饰 ，public abstract 都忽略
// }

// abstract class News {
//     // 抽象类中方法前面的abstract不能省略，否则就是普通方法
//     public abstract void getNews();
// }

// class MessageImpl extends News implements IMessage { // 普通方法中要加上 public
//     public void print() {
//         System.out.println("I am a bitter");
//     }

//     public void getNews() {
//         System.out.println("I am News");
//     }
// }

// public class Interface {
//     public static void main(String[] args) {
//         IMessage m = new MessageImpl();
//         m.print();
//         // MessageImpl 是抽象类和接口的共同子类
//         News news = (News) m; // 拥有共同子类（子接口的）类可以相互转换
//         news.getNews();
//     }
// }

//////////////////////////////
//一个抽象类可以使用implemenets实现多个接口，但是接口不能继承抽象类
//范例：
// interface IMessage {
//     public void print();
// }

// abstract class News implements IMessage {
//     public abstract void getNews();
// }

// class MessageImpl extends News { // MesageImple 是 News 和IMessage 的共同的子类
//     public void print() {
//         System.out.println("I am a biter");
//     }

//     public void getNews() {
//         System.out.println("I am News");
//     }
// }

// public class Interface {
//     public static void main(String[] args) {
//         IMessage m = new MessageImple();
//         m.print();
//         // MessageTmple 是抽象类和接口的共同子类
//         News news = (News) m;
//         news.getNews();
//     }
// }

// 总结：
// 上面的实际上是三层继承结构
// class MessageImpl extends News
// 也可以写成 class MessageImpl extends News implements IMessage
// implementd IMessage 这只是在强调MessageImpl 是IMessage的子类

///////////////////////////////
// 一个接口可以使用extends继承多个父类
// interface A {
//     void printA();
// }

// interface B {
//     void printB();
// }

// interface C extends A, B {
//     void printC();
// }

// class Impl implements C {
//     public void printA() {
//         System.out.println("A");
//     }

//     public void printB() {
//         System.out.println("B");
//     }

//     public void printC() {
//         System.out.println("C");
//     }

// }

// public class Interface {
//     public static void main(String[] args) {
//         C impl = new Impl();
//         impl.printA();
//         
//         impl.printB();
//         impl.printC();
//     }
// }

///****************************************************************
// 接口可以定义一系列的内部结构，包括：内部普通类，内部接口。其中使用
// static 定义的内部接口相当于一个外部接口。
//
// interface A {
//     void printA(); // 抽象方法

//     static interface B {
//         public void printB(); // 使用static 定义，描述一个外部接口
//     }
// }

// class Impl implements A.B, A { // A.B相当于 C类继承抽象内部类B A.B意思就是 外部类的内部类
//     public void printA() {
//         System.out.println("I am A");
//     }

//     public void printB() {
//         System.out.println("I am B");
//     }
// }

// public class Interface {
//     public static void main(String[] args) {
//         A impl = new Impl();
//         impl.printA();
//         A.B im = (A.B) impl;
//         im.printB();
//     }
// }

// *********************************************
// 总结 
// 接口的应用：定义标准 
// 实际开发中有 三大核心应用环境 
// 1.定义标准造作  
// 2.表式能力 
// 3.在分布式当中 暴露远程服务方法

//eg:表示一个标准
interface USB {
    void setup();

    void work();
}

class Computer {
    public void plugin(USB usb) { // 只插USB设备
        usb.setup();
        usb.work();
    }
}

class UDisk implements USB {
    public void setup() {
        System.out.println("安装u盘驱动");
    }

    public void work() {
        System.out.println("u盘开始工作");
    }
}

class PrintDisk implements USB {
    public void setup() {
        System.out.println("安装打印机驱动");
    }

    public void work() {
        System.out.println("打印机开始工作");
    }
}

public class Interface {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.plugin(new UDisk());
        System.out.println("——————————————————");
        computer.plugin(new PrintDisk());
    }
}
//总结：接口和对象多态性的概念结合后，对参数的统一更加明确了。而且可以发现接口是在类上的设计抽象
