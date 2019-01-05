package CollectionOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class CollectionOPTest {
    public static void main(String[] args) {
        //1.forEach输出
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Java", "C++", "Python", "JavaScripe");
        //方法引用
        list.forEach(System.out::println);

        //取得Stream数据流对象
        Stream<String> stream = list.stream();
        System.out.println(stream.count()); //数据的内容数 将集合数据交给Stream之后，就相当于这些数据一个一个进行处理。
    }
}
