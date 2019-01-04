package StreamTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImMethod {
    //    1. 设置取出最大内容: public Stream limit(long maxSize);
//    2. 跳过的数据量: public Stream skip(long n);
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "1、Java", "2、C++", "3、Python", "4、JavaScript", "5、Nginx", "6、 Tomcat");
        //实例化Stream对象
        Stream<String> stream = list.stream();
        List<String> resultList = stream.skip(0).limit(3)
                .map((s) -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(resultList);
    }

}
