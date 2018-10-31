package Test;//在java文件首行定义package包名称

import child.Child;

public class TestPackage {
    public static void main(String[] args) {
        Child child = new Child();
        child.print();
    }
}

//只有用public class 且一个文件只有一个public Class 主类
//文件名与主类名一致。如果希望这个类直接被其他包可以访问，就定义此
//class 定义的类 名字主类不能一致，可以定义多个。但这写类不允许被其他包访问。

//加入要使用不是本包下的其他类就需要导包操作
//import
