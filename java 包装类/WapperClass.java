//Object类可以接回引用数据类型，基本数据类型用包装类来处理
public class WapperClass {
    public static void main(String[] args) throws NumberFormatException {
        //1.包装类的实质
        //IntDemo的使用
        //子类向上转型
        System.out.println("1.____________________________");
        Object object1 = new IntDemo(55);
        IntDemo temp1 = (IntDemo) object1;//向下转型
        System.out.println(temp1.intValue());//取出里面的基本数据类型操作

        System.out.println("2.1____________________________");
        //2.1手工拆装箱
        Integer num = new Integer(55);//装箱
        int data = num.intValue();//拆箱
        System.out.println(data);
        //JDk1.5以后提供自动拆装箱
        //2.1自动装箱
        Integer x = 55;
        //可以直接利用包装类对象操作
        System.out.println(++x * 5);

        System.out.println("2.2____________________________");
        //2.2包装类比较问题
        Integer num1 = new Integer(10);
        Integer num2 = new Integer(10);
        System.out.println(num1 == num2);  //false
        System.out.println(num1 == new Integer(10)); //false
        System.out.println(num1.equals(new Integer(10))); //true
        //跟String类型基本的比较基本相同，但也有特殊的地方。如下：
        Integer num4 = 20;
        Integer num3 = 20;
        Integer num5 = 200;
        Integer num6 = 200;
        System.out.println(num3 == num4);//true
        System.out.println(num6 == num5);//false

        System.out.println("3.1____________________________");
        //3.1字符串与基本数据类型的转换
        String str = "123";//String
        int num7 = Integer.parseInt(str);//123
        System.out.println(num7);

        double num8 = Double.parseDouble(str);//123.0
        System.out.println(num8);

        String str1 = "true";
        boolean boo = Boolean.parseBoolean(str1);//true
        System.out.println(boo);

        System.out.println("3.2____________________________");
        //3.2基本数据类型与字符串的转换
        //1.
        Integer i = 10;
        String str2 = i + "";
        System.out.println(i);//10
        //2.
        String str3 = String.valueOf(i);
        System.out.println(i);//10
    }
}

class IntDemo {
    private int num;

    public IntDemo(int num) {
        this.num = num;
    }

    public int intValue() {
        return this.num;
    }
}
//1.包装类基本原则：基本数据封装到类当中，Object是所有类的超类
//eg：自己定义一个包装类
//IntDemo其实及时int类型的包装类，利用其就可以实现基本数据类变为对象的需求了
//结论：对基本类型的包装本质上就是使用Object进行接受处理

//Java方便开发，提供专门的包装类进行使用，而对子类包装类的使用提供两种类型
//A.对象型（Object的直接子类）：Boolewn ,Character(char);
//b.数值型（Number的直接子类）：Byte,Double,Short,Long,Integer(int),Float;
//关于Number类
//1.Number类的定义：public abstract class Number implements java.io.Serializable
//2.在Number类里面4种抽象方法，2种具体方法

//2.装箱与拆箱*************************************
//A.装箱：将基本数据类型变为包装类对象，利用每个包装类提供的构造方法实现装箱处理。
//B.拆箱：将包装类中包装的基本数据类型取出。利用Number类中提供的六种方法。
//2.2包装类比较问题
//这时候依然存在比较上的问题。“==” 和“equals”

//特殊例子说明
//对于Integer var = ?在-128到127范围内的赋值，跟String相同（在常量池中产生），会复用以有
//对象，这个区间内的Integer的值可以直接用==判断。区间外的所有数据，都会在堆中产生，并不会复用已有对象，
//大坑，推荐使用equals方法进行判断。
//阿里编码规范：使用int还是Integer？
//关于基本数据类型与包装数据类型的使用标准如下： 1） 【强制】所有的 POJO 类属性必须使用包装数据类型。
// 2） 【强制】RPC 方法的返回值和参数必须使用包装数据类型。
// 3） 【推荐】所有的局部变量使用基本数据类型。

//3.字符串与基本类型之间转换***************************
//3.1字符串->基本数据类型
//进行各种数据的输入，一定都是字符串类型的接受。所以在开发之中，如何将字符串变成各个数据类型就需要包装类
//String变为 int(Integer) ,double(Double),boolean(Boolean)
//公式：public static [int/double/boolean] parse[Int/Double/Boolean] (String s)
//且(int double)抛异常 throws NumberFOrmatException

//需要注意的是，将字符串转为数字的时候，字符串的组成有非数字，
// 那么转换就会出现错误 （NumberFormatException），以后就因为这个异常，我们要写一堆程序来回避。


//3.2基本数据类型->字符串
//1.任何数据类型使用了"+"连接空白字符串就变为了字符串类型。
//2.使用String类的valueOf()方法，此方法不产生垃圾空间


