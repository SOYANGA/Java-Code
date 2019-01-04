package StreamTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        //数据过滤
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "C++", "Python", "JavaScript");
        //实例Stream对象
        Stream<String> stream = list.stream();
        //统计出这些数据中带有java的个数
//        System.out.println(stream.filter((e) -> e.contains("Java")).count());
        //收集器 收集过滤的数据
//        System.out.println(stream.filter((e) -> e.contains("Java"))
//                .collect(Collectors.toList()));
        //收集完的数据依然属于List集合，所以可以直接使用List进行接收。
        List<String> resultList = stream.filter((e) -> e.contains("Java")).collect(Collectors.toList());
        System.out.println(resultList);
    }
}
