// //成员内部类的特点
// class Outter {
//     private String outName;
//     private int outAge;

//     class Inner {
//         private int inAge;

//         public Inner() {
//             Outter.this.outAge = 10;
//             Outter.this.outName = "I am Outter Class";
//         }
//         public void display(){
//             System.out.println(outName);
//             System.out.println(outAge);
//         }
//     }
// }

// class MemInner {
//     public static void main(String[] args) {
//         Outter.Inner in = new Outter().new Inner();  //先实例化外部类对象，再实例化内部类对象
//         in.display();
//     }
// }
//总结:
//1.对于成员内部类（非静态内部类），内部类的创建依赖外部类的实例对象，在没有外部类实例化之前是无法创建内部类的
//eg: Outter.Inner in = new Outter().new Inner();
//2.成员内部类不能存在任何static变量或者方法。但可以访问外部类的static方法，自己不能拥有
//假如拥有，则会编译报错  
//3.内部类是一个相对独立的实体，与外部类不是is-a（继承关系）
//4.成员内部类可以直接访问外部类的元素（包括私有域），但外部类不能直接访问内部类的元素
//5.外部类可以通过内部类的间接引用访问内部类的元素
//6.内部类可以使用private封装，表示私有内部类，该内部类仅供外部类使用，
//（HashMap 中的Entry内部类，  ArrayList 中的Node内部类

////外部类间接访问内部类
//1.在外部类的方法中实例化内部类
//2.且在方法中调用内部类的方法 
//3.在主方法中实例化外部类
//4.且调用外部类实例化内部类的方法
class Outter {
    public void display() {
        Inner in = new Inner();
        in.display();
    }

    class Inner {
        public void display() {
            System.out.println("I am InnerClass");
        }
    }
}

public class MemInner {
    public static void main(String[] args) {
        Outter out = new Outter();
        out.display();
    }
}
//创建成员内部类的方法：
//1.在外部类之外创建内部类
//外部类.内部类 内部类对象 =new 外部类().new 内部类();
//Outter.Inner in =new outter().new Inner();
//2.在外部类内部创建内部类的方法
//Inner in = new inner();