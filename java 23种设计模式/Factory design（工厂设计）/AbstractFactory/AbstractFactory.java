
interface Computer {
    void printComputer();
}

class MacPro implements Computer {
    public void printComputer() {
        System.out.println("This is a MacPro");
    }
}

class Surface implements Computer {
    public void printComputer() {
        System.out.println("This is a surFace");
    }
}

interface OperatingSystem {
    void printSystem();
}

class MacOsSystem implements OperatingSystem {
    public void printSystem() {
        System.out.println("This is a mac os");
    }
}

class Windos8System implements OperatingSystem {
    public void printSystem() {
        System.out.println("This is a windows 8");
    }
}

interface ProductionFactory {
    Computer creatComputer();

    OperatingSystem creatSystem();
}

class AppleFactory implements ProductionFactory {
    public Computer creatComputer() {
        return new MacPro();
    }

    public OperatingSystem creatSystem() {
        return new MacOsSystem();
    }
}

class MsFactory implements ProductionFactory {
    public Computer creatComputer() {
        return new Surface();
    }

    public OperatingSystem creatSystem() {
        return new Windos8System();
    }
}

public class AbstractFactory {
    public void buyComputer(Computer computer) {
        computer.printComputer();
    }

    public void use(OperatingSystem system) {
        system.printSystem();
    }

    public static void main(String[] args) {
        AbstractFactory client = new AbstractFactory();
        ProductionFactory factory = new MsFactory();
        Computer computer = factory.creatComputer();
        OperatingSystem system = factory.creatSystem();
        client.buyComputer(computer);
        client.use(system);
    }
}
/**
概要：
1.多个抽象类
2.具体产品类
3.抽象工厂类-声明（一组）返回抽象产品的方法
4.具体工厂类 -生成（一组）具体产品

优点：
1.代码解耦
2.实现多个产品族（相关联关产品组成的家族），而工厂方法模式的单个产品，可以满足更多的生产需求
3.很好的满足OCP开放封闭原则
4.抽象工厂模式中我们可以定义实现不止一个接口，一个工厂也可以生成不止一个产品类，对于复杂对象的
生产组相当灵活易扩展

缺点：
1.扩展产品族相当麻烦而且扩展产品族会违反OCP因为要修改所有的工厂
2.由于抽象工厂模式是工厂方法模式的扩展 总体的来说 很笨重
 */