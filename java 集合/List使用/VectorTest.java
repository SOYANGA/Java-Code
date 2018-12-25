package ListTest;

import java.util.List;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        List<String> list = new Vector<>();
        list.add("Hello");
        list.add("hello");
        list.add("bit");
        System.out.println(list);
        list.remove("hello");
        System.out.println(list);
    }
}

//