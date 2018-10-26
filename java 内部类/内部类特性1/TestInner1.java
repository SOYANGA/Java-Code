//内部类的优点1 ：内部类可以与外部类访问到彼此的私有域  （普通域）

class Outter {
    private String msg = "I am Outter"; // 外部类私有属性
    public int age = 20; // 外部类普通属性（公共）

    // ********
    class Inner { // 定义一个内部类
        private String name = "I am  Inner";// 内部类私有属性
        public int age = 10;// 内部类公共属性

        public void print() { // 定义一个普通方法
            System.out.println(Outter.this.msg); // 内部类可以访问彼此的私有域
        }

        public void name() { // 内部类方法 访问内部类的私有属性
            System.out.println(name);
            System.out.println(Outter.this.age);//内部类可以直接访问到外部类的公共属性
        }
    }

    // **************
    // 在外部类中定义一个方法，该方法负责生成内部类对象 并且调用print()方法
    public void fun() {
        Inner in = new Inner();// 创建一个内部类
        in.print(); // 内部类提供的方法 访问外部类的私有属性
        in.name(); // 调用内部类的方法 访问内部类的私有属性
        System.out.println(in.age); // 外部类直接访问内部列的公共属性
    }

}

public class TestInner1 {
    public static void main(String[] args) {
        Outter out = new Outter();// 外部类对象
        out.fun();// 外部类方法
    }
}

// 通过实例化且调用外部类的一个方法
// 这个方法中实例化了内部类的对象，且调用内部类的方法 访问到外部类的私有属性
// 证明:内部类可以直接访问到外部类的私有属性

// 证明：而外部类需要间接可以访问内部类的私有属性
// 通过，外部类调用方法 创建内部类的实例化，进而调用内部类的方法访问内部类的属性

// 总结:
// 即：外部类和内部类可以访问彼此的私有属性 则普通属性也就可以访问到
// 1.内部类可以直接访问到外部类的方法，属性   通过   Ou .  

// 2.外部类则需要调用内部类的方法，进而访问到外部类的私有属性/方法  
// 3.普通是属性方法内外部类可以彼此直接访问。
