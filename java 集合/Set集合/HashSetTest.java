package SetTest;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("Bit");
        set.add("Hello");
        set.add("Java");
        System.out.println(set);
    }
}

//本质上是一个HashMap
//不允许有重复的元素（底层实际上是使用HashMap的key值存储数据，
// value值存了一个无用的值PRESENT ）
//Object 实例对象PRESENT

//且得出的值是按照hash算法的出的hashcode按照hashcode存储的数据（无序性）