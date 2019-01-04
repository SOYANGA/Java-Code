package Maptest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapIterastor {
    public static void main(String[] args) {
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "张三");
//        map.put(2, "李四");
//        map.put(3, "王五");
//        //输出map集合
//        //1.map->set
//        Set<Map.Entry<Integer, String>> set = map.entrySet();
//
//        //.取得set接口的迭代器
//        Iterator<Map.Entry<Integer, String>> iterator =
//                set.iterator();
//        //迭代输出
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, String> entry =
//                    iterator.next();
//            System.out.println(entry.getKey() + "=" + entry.getValue());
//        }

        Map<Integer, String> map = new HashMap();
        map.put(1, "hello");
        map.put(2, "bit");
        map.put(3, "java");
        //1.将Map集合转变为Set集合
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        //2.获取iterator对象
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        //3.输出
        while (iterator.hasNext()) {
            //取出每个Map.Entry对象
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
