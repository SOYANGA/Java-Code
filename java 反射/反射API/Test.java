package MethodeTest;


import java.lang.reflect.Field;
import java.nio.file.Paths;

class Person {
    public int age;
}

public class Test {
    public static void main(String[] args) throws Exception {
        //1Class对象调用getfield 取得Field 对象
        Class cls = Person.class;

        Field field = cls.getField("age");
        //取得Person实例化对象
        Person per = (Person) cls.newInstance();
        field.set(per, 20);
        System.out.println(field.get(per));
        System.out.println(field.getType());
    }
}
