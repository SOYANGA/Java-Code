package IteratorTest;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//双向迭代接口：ListIterator
public class ListIteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Hello");
        list.add("B");
        list.add("Bit");
        list.add("Bit");
        ListIterator<String> listIterator = list.listIterator();//取得ListIterator实例化对象
        ListIterator<String> listIterator1 = list.listIterator();//取得ListIterator实例化对象

        System.out.println("从前向后输出");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + ",");
        }
        System.out.println("\n从后向前输出");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + ",");
        }

        System.out.println("\n从后向前输出实验");
        while (listIterator1.hasPrevious()) {
            System.out.print(listIterator1.previous() + ",");
        }
    }
}
