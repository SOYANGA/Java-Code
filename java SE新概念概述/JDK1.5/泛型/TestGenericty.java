//泛型指的就是在类定义的时候并不会设置类中属性方法的参数
//的具体类型，而是在类使用时再进行定义。

class Point<T> {  //T表示参数，是一个占位的标记；如果有多个泛型就继续在后面追加
    private T x;
    private T y;


    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}

class Point1<T, E> {
    private T x;
    private E y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public E getY() {
        return y;
    }

    public void setY(E y) {
        this.y = y;
    }
}

class MyClass<T extends Object> {  //设置上限 最高父类
    private T type;

    public void testMethod1(T t) {//普通方法 T为类中T
        System.out.println(t);
    }

    //泛型方法
    public <T> T testMethos2(T t) {  //T类型与类中无关，都是代指
        return t;
    }

    public <E> E testMethod3(E e) { //泛型方法
        return e;
    }

}

interface IMessage<T> { //在接口上定义了泛型
    void print(T t);
}

//子类实现接口时继续保持接口 泛型子类
class MessageImpl<T> implements IMessage<T> {
    @Override
    public void print(T t) {
        System.out.println(t);
    }
}

//子类实现接口时明确接口类型参数
class MessageImpl1 implements IMessage<String> {
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}

public class TestGenericty {
    public static void main(String[] args) {
        System.out.println("1.泛型类——————————————————————");
        //设置数据
        Point<String> p = new Point<String>();//JDK1.5语法
        p.setX("东经80度");
        p.setY("北纬20度");
        //取出数据
        String x = p.getX();  //避免向下转型
        String y = p.getY();
        System.out.println("x=" + x + "  y=" + y);
        //设置数据 不同的数据
        Point1<String, Integer> p1 = new Point1<>();//JDK1.7以后可以这样写
        p1.setX("杨益行");
        p1.setY(10);
        String x1 = p1.getX();
        int y1 = p1.getY(); //自动拆箱
        System.out.println(x1 + "\n" + y1);

        System.out.println("2.泛型方法————————————————————————");
        //2.泛型方法
        MyClass<String> my = new MyClass<>();
        my.testMethod1("哈哈哈");//普通方法，使用类中的类型
        Integer i = my.testMethos2(100);//泛型方法
        System.out.println(i);
        System.out.println(my.testMethod3(10.0));

        System.out.println("3.通配符———————————————————————————");
        //3.通配符
        Point<Integer> test = new Point<>();
        test.setX(10);
//        fun(test); //出现错误此时只能接受String
        //因为下面定义了Stirng的Point泛型类的对象
        fun2(test);
        fun3(test);
        System.out.println("4.泛型接口——————————————————————————");
        IMessage<Integer> msg = new MessageImpl();
        msg.print(10);
        IMessage msg1 = new MessageImpl1();
        msg1.print("Hi World");
    }

    public static void fun1(Point<String> temp) {
        System.out.println(temp.getX());
    }

    // 此时使用通配符"?"描述的是它可以接收任意类型，
    // 但是由于不确定类型，所以无法修改
    public static void fun2(Point<?> temp) {
//        temp.setX(100);  //出现错误无法修改 父类到子类不一定可以实现向下转型
        System.out.println(temp.getX());
    }

    // 此时使用通配符"?"描述的是它可以接收任意类型，但是由于不确定类型，所以无法修改
    public static void fun3(Point<? extends Number> temp) {
        //temp.setX(100); //出现错误 无法修改
        System.out.println(temp.getX());
    }

    public static void fun4(Point<? super String> temp) {
        temp.setX("ad");  //可以修改！！  子类到父类 天然的向上转型
        System.out.println(temp.getX());
    }
}
//一、泛型的基本使用：
//I泛型类

//1.尖括号中的T称作为类型参数，用于指代任何类型。
//实际上这个参数可以任意写，但出于规范。java还是建议我们用大写字母
//代表类型参数。
//T 代表一般的任何类
//E 代表Element的意思，或者Exception异常的意思。
//k代表key的意思
//V 代表Value的意思，通常使用k一起配合使用。
//S代表Subtype的意思，文章后面会讲解
//一个类被<>修饰那么他就是泛型类

//注意：
//1.泛型类可以接受多个类型参数，且只能接受引用类型，假如
//要使用基本类型则必须要使用包装类
//2.泛型彻底解决了向下转型带来的可能在运行时会发生ClasscaseException异常
//3.泛型指的就是在类定义的时候并不会设置类中属性方法的参数
//的具体类型，而是在类使用时再进行定义。
//假如没有设置类型则默认为Object

//II泛型方法
//1.当作参数类型
//类型参数<T>那部分写在返回值前面。<T>中的T被称为类型参数，而方法中的
//T被成为为参数化类型，它不是运行真正的参数。
//public <T> void testMethod(T t){
//    System.out.println(t);
//}

//2.当作返回值类型
//也可以作为，声明类型参数，当作返回值的类型
//public <T> T testMethod(T t){
//    return t;
//}

//当泛型方法和泛型类共存时，泛型方法中的类型参数与泛型方法中的无关，
// 泛型方法始终以自己定义的参数为准。

//规范起见：当泛型与泛型方法共存时，请使用不同的类型参数来区分彼此

//二、通配符（重点）
//我们需要的解决方案：可以接收所有的泛型类型，但是又不能够让用户随意修改。
// 这种情况就需要使用通配符"?"来 处理

//2.1 ？
//程序追加泛型的定义后，避免ClassException 的问题，但是又会产生
//新的问题：参数统一的问题

//在对象作为参数时，需要定义泛型（对象的泛型属性），
// 此时假如传入不是此泛型参数（对象的泛型属性）的对象
//则会出现错误（编译期间）

//无法确定入参类型：？设置通配符下的泛型参数，只能取得类中属性，无法进行属性的设置
//原因：无法确定属性的类型，无法设置具体类型参数。

//2.2 泛型上限 ？ extends （最高位）父类
//A.类上设置泛型上限
// eg: class Person <T extends Number> {//设置泛型上限
//
//}
//表示只能设置Number及其子类 例如：Integer、Double；
//  其可以转换的类型参数必须是自己及其子类。
//不能更改泛型属性，只能取得其泛型属性。
//
//B.作为参数时设置泛型上限
//  public static void fun(Person <? extends Nunmber> temp){
//}
////此时使用通配符“？”描述的是它可以接受任意类型，
// 但是由于不确定类型，所以无法修改

//2.3设置下限  ？ super （最低位）子类
//
//只能用在方法参数，且可以修改内容
//上限可以用在声明，方法参数  ；而下限只能用在方法参数上，可以修改内容！！！

//三、泛型接口

//对于这个接口的实现子类有两种做法
//1.子类实现接口时继续保持泛型
//class MessageImpl<T> implements IMessage<T>{
//
//}

//2.子类在实现接口时明确（确定）类型参数
//class MessageImpl implements IMessage<String>{
//
//}

//四、类型擦除
//1.泛型只存在于代码编译阶段，在进入JVM之前，与泛型相关的信息会被擦除掉，专业术语叫
//类型擦除

//其实，泛型类和普通类在java虚拟机看来时没有什么特别的地方。
//
//2.在泛型被类型擦除的时候，之前泛型中的类型参数部分如果没有指定上限，如果<T>则会被
//转译成普通Object类型，如果指定了上限如<T extends String>则类型参数就被替换成类型上限。
//（转换为其最高父类）
