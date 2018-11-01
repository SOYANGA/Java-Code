
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/*
 *单例设计模式：一个类只允许产生一个实例化对象
 */
public class SingletonTest {
    public static void main(String[] args) throws IOException {

        System.out.println("2.1饿汉单例__________________________");
        //2.1饿汉式 (im)
        Singleton1 singleon = null;//声明对象
        singleon = Singleton1.getInstance(); //获得对象

        Singleton1 singleon1 = Singleton1.getInstance();//直接获得
        singleon.print();
        singleon1.print1();

        System.out.println("2.2懒汉单例________________________");
        //2.2懒汉式(qu)
        Singleton2 singleon2 = null;//声明对象
        singleon2 = Singleton2.getInstance(); //获得对象
        singleon2.print();


        System.out.println("3多例__________________________");
        //3.多例设计模式
        Sex male = Sex.getInstance(Sex.MALE_FLAG);
        Sex female = Sex.getInstance(Sex.FEMALE_FLAG);
        System.out.println(male);
        System.out.println(female);


        //文件读写（pl）
        Scanner in = new Scanner(Paths.get("D:\\阿婕.txt"), "UTF-8");
        PrintWriter out = new PrintWriter("D:\\阿婕.txt", "UTF-8");
        out.write("Hello SOYANGA\nHello Jennie");
        out.close();
        System.out.println(in.nextLine());
        System.out.println(in.nextLine());
        in.close();
    }
}
//一、单例模式组成

//要做到一个只允许产生一个实例化对象：
//1.私有化构造方法（private）
// 因为：拥有可以调用一个类的构造方法，则可以实例化无限个对象
//但私有化构造方法则：无法在类外部实例化这个类的对象
//所以：
//2.用private final static 在类的内部实例化好一个对象
//原因：private 私有属性
//static：在类内部实例化的普通属性，只有实例化对象的时候才能进行内存空间的分配。
//而现在外部无法产生实例化对象，所有我们必须要在类还没有实例化对象产生的时候，
//也可以使用我们在类中实例化的对象。所以我们使用static 关键字。
//且static 关键修饰的属性和类相关，只有在类加载的时候分配空间产生（类加载只加载一次）
//刚好使用static 既可以解决只产生一个对象且可以不依赖对象实例化产生
//3.虽然可以取得类的实例化对象，但对类中属性应该用private封装，想要取得该属性
//就需要提供getter（）方法。
//但由于这个类无法在外部提供实例化对象，应该提供一个static修饰的getter（）方法，
//因为static方法不受对象实例化控制


//3.由于产生的对象（静态属性）

//二、单利设计模式：两种方式
//2.1饿汉式
// 用fianl修饰实例化的对象（饿汉式）
// 不管你是否使用Singleton类的对象，只要该类加载了，那么一定会自动创建
// 好一个公共的instance对象。既然是饿汉式，就希望整体的操作之中只能够有一个实例化对象，
// 所以一般还会在前 面追加一个final关键字

//特点：构造方法私有化。外部无法产生此类的实例化对象，只能通过static方法
// 取得实例化对象
//范例：懒汉单例模式
class Singleton1 {
    // 在类的内部可以访问私有结构，所以可以在类的内部产生实例化对象
    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {//私有化构造方法
    }

    public static Singleton1 getInstance() {

        return INSTANCE;
    }

    public void print() {

        System.out.println("Hello SOYANGA");
    }

    public void print1() {
        System.out.println("Hello Jennie");
    }
}

//2.2懒汉式
//不用final修饰：使用对象时才去在类的内部实例化对象（需要修改）
//特点：构造方法私有化，外部类无法产生新的实例化对象，只能通过static方法
//取得实例化对象
//范例：懒汉式单例设计模式模式
//特点：当第一次去使用对象时才会为其产生实例化对象的操作
class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {// private声明构造

    }

    public static Singleton2 getInstance() {
        if (instance == null) { // 表示此时还没有实例化
            instance = new Singleton2();
        }
        return instance;
    }

    public void print() {
        System.out.println("Hi Mujie");
    }
}

//三、多例设计模式（理解）
//一周只有7天，描述性别的只有两个（确定只有有限个对象）
//所谓多例只是比单例追加了更多个内部实例化对象

class Sex {
    private String title;
    public static final int MALE_FLAG = 1;
    public static final int FEMALE_FLAG = 2;
    private static final Sex MALE = new Sex("男");
    private static final Sex FEMALE = new Sex("女");

    private Sex(String title) {
        this.title = title;
    }

    public static Sex getInstance(int flag) {
        switch (flag) {
            case MALE_FLAG: {
                return MALE;
            }
            case FEMALE_FLAG: {
                return FEMALE;
            }
            default: {
                return null;
            }
        }
    }

    @Override
    public String toString() {
        return this.title;
    }
}


//总结：
// 1. 构造方法私有化。
// 2. 类内部一定会提供一个static方法用于取得实例化对象。
//（懒汉式存在多线程安全问题，而饿汉式不会。）
//面试时就写饿汉式。
//问题：
//面试：如何解决懒汉式的线程安全问题?(后面会讲)(双重加速单例模式)
