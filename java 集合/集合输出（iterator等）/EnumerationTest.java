package IteratorTest;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationTest {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Hello");
        vector.add("Hello");
        vector.add("B");
        vector.add("Bit");
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
