package ListTest;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("哈哈");
        list.add("Hello");
        list.add("Hello");
        System.out.println(list);
        list.remove("Hello");
        System.out.println(list);
    }
}
