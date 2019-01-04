package CollectionsTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //相当于调用三次add方法
        Collections.addAll(list, "A", "B", "c");
        System.out.println(list);
        //集合反转
        Collections.reverse(list);
        System.out.println(list);
    }
}
