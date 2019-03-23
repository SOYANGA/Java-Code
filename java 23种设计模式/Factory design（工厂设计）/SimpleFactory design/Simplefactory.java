import java.util.Scanner;

interface Computer {
    void printComputer();
}

class Macpro implements Computer {
    public void printComputer() {
        System.out.println("This is a Macpro with bar");
    }
}

class Surface implements Computer {
    public void printComputer() {
        System.out.println("This is a Surface");
    }
}

class VailWare implements Computer {
    public void printComputer() {
        System.out.println("This is a VailWare");
    }
}

class ElseType implements Computer {
    public void printComputer() {
        System.out.println("Exit  succeeful!");
    }
}

class Factory { // 工厂类  解耦者 第三方 关键
    public static Computer make(String name) {
        Computer computer = null;
        do {
            if (name.equals("mac")) {
                computer = new Macpro();
                break;
            } else if (name.equals("surface")) {
                computer = new Surface();
                break;
            } else if (name.equals("Vail")) {
                computer = new VailWare();
                break;
            } else if (name.equals("exit")) {
                computer = new ElseType();
                break;
            } else {
                System.out.println("不好意思你所要的电脑型号暂时没有.如果想要退出请输入：exit \n否则请重新输入你要的电脑的型号：");
                Scanner scanner = new Scanner(System.in);
                name = scanner.nextLine();
            }
        } while (true);
        return computer;
    }

}

public class Simplefactory {  //客户端
    public void buyComputer(Computer computer) {
        computer.printComputer();
    }

    public static void main(String[] args) {
        Simplefactory client = new Simplefactory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想要的电脑型号:");
        String type = scanner.nextLine();
        Computer computer = Factory.make(type);
        client.buyComputer(computer);
        scanner.close();
    }
}
//概要
//简单工厂模式：
//1.一个抽象产品类
//2.具体产品类
//3.一个工厂
//优点
//1.简单易于实现
//2.把类的实例化交给工厂，易于解耦
//缺点
//1.添加具体产品需要修改工厂给违反OCP开放封闭原则