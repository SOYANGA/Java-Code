package IteratorTest;

import java.util.ArrayList;
import java.util.List;

public class ForEachtest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Hello");
        list.add("B");
        list.add("Bit");
        for (String str : list) {
            System.out.println(str);
        }

    }

}
