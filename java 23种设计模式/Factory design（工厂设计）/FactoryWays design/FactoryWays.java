interface Computer{
    void printComputer();
}
class MacPro implements Computer{
    public void printComputer(){
        System.out.println("This is a MacPro");
    }
}
class Surface implements Computer{
    public void printComputer(){
        System.out.println("This is a Surface");
    }
}
interface ComputerFactory{
    Computer creatComputer();
}
class MsFactory implements ComputerFactory{
    public Computer creatComputer(){
        return new Surface();
    }
}
class AppleFactory implements ComputerFactory{
    public Computer creatComputer(){
        return new MacPro();
    }
}


public class FactoryWays{ //客户端
    public void buyComputer(Computer computer){
        computer.printComputer();
    }
    public static void main(String[] args) {
        FactoryWays client =new FactoryWays();
        ComputerFactory factory =new AppleFactory();
        client.buyComputer(factory.creatComputer());
    }
}
/*
工厂方法模式针对每一个产品提供有一个类，在客户端判断使用哪个工厂类去创建对象
对比简单工厂模式 和工厂方法模式：
对简单工厂模式而言，创建对象的逻辑判断放到工厂类中，用户感知不到具体类，但其
违背了开闭原则，如果要增加新的具体类，就必须修改工厂类

对于工厂方法模式，是通过扩展来新增具体类，符合开闭原则，但在客户端就必须要感知
到具体的工厂类，也就是将判断逻辑由简单工厂的工厂类挪到客户端中。

工厂类模式横向扩展
                方便，加入该工厂又有新的产品Mac AIR 生产，那么只需要创建相应
的工厂类和产品类去实现抽象工厂接口和抽象产品线即可，而不用去修改原有已经存在的代码。
///////////////////////
概要：
1.一个抽象产品类
2.多个具体产品类
3.一个抽象工厂
4.多个具体工厂，每个具体产品对应一个具体工厂

优点
1.降低了代码耦合度，对象的生成交给子类完成。
2.实现了开放封闭原则，每次添加子类产品，不需要的修改原有代码

缺点
1.增加代码量 ，每个具体产品都需要一个具体的工厂
2.当增加抽象产品，也就是添加一个其他的产品族，需要修改工厂违背OCP

**/