import test.java.util.myMath; //普通导入

import static test.java.util.myMath.*;//静态导入

public class staticImport {
    public static void main(String[] args) {
        System.out.println(add(0, 1));//静态导入直接使用 静态方法
        System.out.println(myMath.add(0, 1));//普通导入
        System.out.println(sub(1,2));
    }
}
//3.静态导入（了解）
//如果要导入包中要使用的类的所有方法全是static方法，则可以利用静态导入
//将此包直接导入静态导入进来，其中的导入进来的类的所有静态方法可以直接
//使用，当做自己类的方法使用

//import static (包)+类+*；（相当于类的补充）
//import static test.java.util.Mymath.*;//静态导入
//ctrl + alt + o：自动导入删除包