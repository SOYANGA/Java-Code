package IteratorTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTestDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Hello");
        list.add("B");
        list.add("Bit");
        list.add("Bit");
        Iterator<String> iterator = list.iterator();//实例化Iterator对象
        //迭代输出
        System.out.println("----迭代输出----------");
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }
        System.out.println("-------遍历且删除元素B-------");
        //删除元素
        Iterator<String> iterator1 = list.iterator();//实例化Iterator对象
        while (iterator1.hasNext()) {
            String str = iterator1.next();
            if (str.equals("B")) {
                //使用集合类=提供的remove()方法，否则会产生ConcurrentModificationException
                //list.remove("B")；
                //使用iterator的remove方法则不会产生异常
                //原因想不起来旧看一下笔记傻蛋！（提个醒(iterator是list的一个副本)，记录修改次数的变量modCount++;）
                iterator1.remove();
                continue;
            }
            System.out.println(str);
        }
    }

}
//其实使用的是Collection实现Iterable中的iterator()方法
//public interface Collection<E> extends Iterable<E>
//所有Collection子类都具有这个方法

