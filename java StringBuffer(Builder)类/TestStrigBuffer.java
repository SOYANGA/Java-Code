//String类特点：回顾
//任何字符常量都是String对象，而且String的常量一旦声明就不可改变，如果改变对象内容，
//其实只是改变的是其引用的指向而已（在对象池中找创建新的对象）（对象池相当于：对象数组）

//通常来说String的操作简单，由于其不可更改的特性，为了方便字符串的修改，提供String Buffer类。
//在String中使用+来进行字符串的链接，但是这个操作在StringBuffer类中需要修改为append（）方法：
// public sysnchronized StringBuffer append(各种数据类型 b)

import java.sql.SQLOutput;

public class TestStrigBuffer {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer("helloworld");
        sb.append("Hello").append("World");
        //1.字符串拼接 （+各种类型的数据）
        add(sb);
        System.out.println(sb);
        //2.字符串删除
        System.out.println(sb1);
        delete(sb1);
        System.out.println(sb1);
        //3.字符串插入（+各种类型的数据）
        insert(sb1);
        System.out.println(sb1);

    }

    public static void add(StringBuffer temp) {

        temp.append("\n").append("www.bit.com.cn");
    }

    public static void delete(StringBuffer temp) {
        temp.delete(5, 10);
    }

    public static void insert(StringBuffer temp) {
        temp.insert(0, 4399);
    }
}
//一、String 和 StringBuffer 转换和区别
//String 和 StringBuffer最大的区别在于：String的内容无法修改，而StringBuffer的内容可以修改
//频繁修改字符串的情况下使用StringBuffer。
//更好的理解这俩个类
//两个类都是”CharSequence“接口的子类。这个接口描述的是一系列的字符集。
//所以字符串是字符集的子类，看到CharSequence，就简单联想到字符串

//注意：String和StringBuffer不能直接转换
//转换原则：
//1.String变为StringBuffer利用StringBuffer的构造方法后append（）方法
//2.StringBuffer变为Stirng，调用toString()方法

//二、StirngBuffer和StringBuilder 区别
//1.String的内容不能修改，String Buffer与String Build的内容可以修改
//2.StringBuffer采用同步处理，属于线程安全操作，
// 而StringBuilder采用异步处理，属于线程不安全操作

