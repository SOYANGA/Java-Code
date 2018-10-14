import java.util.Scanner; //Scanner 所在的包  相当于c语言的头文件  源文件的声明

public class Tabuada {

    public static void main(String[] args) { // 主方法
        Scanner scanner = new Scanner(System.in); // 相当于c语言的scanf 创建对象，传入一个参数 构造器
        int x = scanner.nextInt(); // .nestline //调用方法 打开输入流
        int y = scanner.nextInt();
        scanner.close(); // 关闭输入流
        Tabuada1(x, y); //

    }

    public static void Tabuada1(int x, int y) { // 计算器实现方法
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + (i * j) + "\t");
            }
            System.out.println("\n");
        }
    }

}