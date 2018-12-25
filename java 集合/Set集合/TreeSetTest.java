package SetTest;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("c");
        set.add("d");
        set.add("b");
        set.add("a");
        set.add("A");
        set.add("ca");
        set.add("cb");
        System.out.println(set);

    }
}
//TreeSet不重复性跟HashSet类似，底层是由Map实现的（TreeMap）
//TreeSet:只使用了K值，value存放了一个value值存了一个无用的值PRESENT ）
//Object 实例对象PRESENT

//但TreeSet是有序的集合，使用的是升序排列的模式完成的。

//