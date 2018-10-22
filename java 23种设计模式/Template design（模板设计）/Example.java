//初始设计 有缺陷
// class Coffee {
//     void prepareRecipe() {
//         boilwater();
//         brewCoffee();
//         pourInCup();
//         addSugarAddMilk();
//     }

//     void boilwater() {
//         System.out.println("将水烧开");
//     }

//     void brewCoffee() {
//         System.out.println("用水冲咖啡");
//     }

//     void pourInCup() {
//         System.out.println("将咖啡倒入杯中");
//     }

//     void addSugarAddMilk() {
//         System.out.println("加糖或牛奶");
//     }
// }

// class Tea {
//     void prepareRecipe() {
//         boilwater();
//         steepTeaBag();
//         pourInCup();
//         addLemon();
//     }

//     void boilwater() {
//         System.out.println("将水少开");
//     }

//     void steepTeaBag() {
//         System.out.println("用水泡茶包");
//     }

//     void pourInCup() {
//         System.out.println("姜茶倒入杯中");
//     }

//     void addLemon() {
//         System.out.println("加柠檬");
//     }
// }

// public class Example {
//     public static void main(String[] args) {
//         Coffee coffee = new Coffee();
//         coffee.prepareRecipe();
//         Tea tea = new Tea();
//         tea.prepareRecipe();
//     }
// }
//****************************************************************************
import java.util.Scanner;

//模板设计
abstract class CaffeineBeverage {
    // 核心冲泡法
    // 封装算法：只能用不能改 final修饰
    final void prepareRecipe() {
        boilwater();
        brew();
        pourInCup();
        // 扩展
        if (customerWantCondments()) {
            addCondments();
        }
    }

    final void boilwater() {
        System.out.println("将水烧开");
    }

    abstract void brew();

    final void pourInCup() {
        System.out.println("将饮料倒入杯中");
    }

    abstract void addCondments();

    // 钩子方法（普通方法）子类可以选择覆写 也可以选择不覆写
    // 子类可以选择性的挂钩
    boolean customerWantCondments() {
        return true;
    }
}

class Coffee extends CaffeineBeverage {
    void brew() {
        System.out.println("用水冲咖啡");
    }

    void addCondments() {
        System.out.println("加糖或牛奶");
    }
}

class Tea extends CaffeineBeverage {
    void brew() {
        System.out.println("用水浸泡咖啡");
    }

    void addCondments() {
        System.out.println("加柠檬");
    }

    boolean customerWantCondments() {
        System.out.println("请问宁需要加柠檬吗？ y/n");
        String result = getUserInfo();
        if (result.equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    private String getUserInfo() {
        String str = null;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        scanner.close();
        return str;
    }

}

public class Example {

    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        coffee.prepareRecipe();
        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();
    }
}
