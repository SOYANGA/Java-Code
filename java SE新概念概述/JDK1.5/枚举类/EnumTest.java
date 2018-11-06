class Color1 {
    private String title;
    public static final int REC_FLAG = 1;
    public static final int GREEN_FLAG = 5;
    public static final int BLUE_FLAG = 10;
    //保证任意两个数加起来不会等于另一个数
    private static final Color1 RED = new Color1("RED");
    private static final Color1 GREEN = new Color1("GREEN");
    private static final Color1 BLUE = new Color1("BLUE");

    private Color1(String title) {
        this.title = title;
    }

    public static Color1 getInstance(int ch) {
        switch (ch) {
            case REC_FLAG:
                return RED;
            case GREEN_FLAG:
                return GREEN;
            case BLUE_FLAG:
                return BLUE;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return this.title;
    }
}

enum Color {
    RED, GREEN, BLUE
}

enum Color2 {
    RED("红色"), GREEN("绿色"), BLUE("蓝色"); //如果有很多内容，枚举对象必须写在第一行
    private String title;

    private Color2(String title) { //构造方法私有化
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }

}

interface IColor {
    public String getColor();
}

enum Color3 implements IColor {
    RED("红色"), GREEN("绿色"), BLUE("蓝色"); //如果有很多内容，枚举对象必须写在第一行
    private String title;

    private Color3(String title) { //构造方法私有化
        this.title = title;
    }

//    @Override
//    public String toString() {
//        return this.title;
//    }

    @Override
    public String getColor() {
        return this.title;
    }
}

enum Sex {
    MALE("男"), FEMALE("女");
    private String title;

    private Sex(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}

class Person {
    private String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Color1.getInstance((Color1.BLUE_FLAG)));//1.JDK1.5之前采用多例模式
        System.out.println(Color.BLUE);  //2.枚举实际上就是高级的多例模式
        //取得枚举编号，取得枚举对象名称
        System.out.println(Color.BLUE.ordinal() + "=" + Color.BLUE.name());
        //取得所有枚举数据
        for (Color temp : Color.values()) {
            System.out.println(temp.ordinal() + "=" + temp.name());
        }
        //3.在枚举中定义更多结构 -构造方法、私有属性
        System.out.println(Color2.BLUE);
        for (Color2 temp : Color2.values()) {
            System.out.println(temp.ordinal() + "=" + temp);
        }
        //3.1枚举是实现接口
        IColor iColor = Color3.BLUE;
        System.out.println(iColor.getColor());
        //枚举的应用
        Person person = new Person("阿婕", 20, Sex.FEMALE);
        System.out.println(person);
    }
}
//1.枚举类（java.lang.Enum类）(高级多例模式)
//Enum是一个抽象类
//枚举相当于一个类，且是一个实现多例模式的一个类
//具有多例模式类中的所有特性：
//私有构造方法
//在类中有一个private static (final)修饰的对象（类属性）--即枚举变量
//有一个static静态的方法返回类中实例化好的对象。--或其中的属性
//由于枚举本质上是一个类：所以他具有一个类中应该有的所有东西
//所以他可以扩展普通属性，普通方法。

//2
//取得枚举名称：
//public final String name();
//取得枚举编号：
//public final int ordinal();
//取得枚举中所有枚举对象
//枚举类.Value():Enum[] -静态


//注意：
//3.枚举中定义其他结构
//枚举中定义的其他结构：枚举对象一定要放在首行声明。
//枚举还可以实现接口，此时枚举中的每个对象都有可能成为就口对象。


//enum和Enum区别：
//enum是一个关键字，使用enum定义的枚举本质上就相当于一个类继承了Enum这个抽象类。

//枚举类最大特点：只指定的几个对象可以使用。
//枚举可以用于switch判断
