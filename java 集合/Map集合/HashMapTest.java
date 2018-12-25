package Maptest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Map基本操作-HashMap
public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Hello");
        //key重复（更新，覆盖）
        map.put(1, "Hello");
        map.put(2, "JAVA");
        map.put(3, "BIT");
        System.out.println(map);
        //根据Key值获得value
        System.out.println(map.get(2));
        //查找不到返回null
        System.out.println(map.get(99));
        //取得map中所有key信息
        Set<Integer> set = map.keySet(); //其实就时key值变成Set集合，再进行遍历
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
