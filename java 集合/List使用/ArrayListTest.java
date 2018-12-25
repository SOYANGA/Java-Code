package ListTest;

import java.awt.print.PrinterGraphics;
import java.util.*;


class Person1 {
    private String name;
    private Integer age;

    public Person1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return "Person1{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }

    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || this.getClass() != o.getClass())
//            return false;
//        Person1 person1 = (Person1) o;
//        return Objects.equals(name, person1.name) &&
//                Objects.equals(age, person1.age);
//    }
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null) {
            return false;
        } else if (!(o instanceof Person)) {
            return false;
        }
        Person1 per = (Person1) o;
        return this.age.equals(per.age)
                && this.name.equals(per.name);
    }
}

public class ListTest {
    public static void main(String[] args) {
        Person1 person = new Person1("挖的", 15);
        //集合保存String类型
        List<String> list = new ArrayList<>();
        System.out.println(list.size() + "," + list.isEmpty());
        list.add("Hello");
        //list可以包含重复数据
        list.add("Hello");
        list.add("bit");
        System.out.println(list.size() + "," + list.isEmpty());
        System.out.println(list);
        System.out.println(list.remove("Hello"));
        System.out.println(list.contains("bit"));
        System.out.println(list.contains("ABC"));
        System.out.println(list);
        System.out.println(list.get(1));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println(" ---Collection进行输出操作----------");

        //Collection进行输出操作
        Collection<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("bit");
        list1.add("How are you");
        //操作由于Collection可以存储任何形式，所以用Object存储，
        // 有可能需要向下转型，有可能产生ClassCasrtException

        Object[] result = list1.toArray();//变成对象数组，才可以输出
        System.out.println(Arrays.toString(result));


        System.out.println(" ---集合与简单java类（自定义集合）----------");

        //集合与简单java类（自定义集合）

        List<Person1> personList = new ArrayList<>();
        personList.add(new Person1("张三", 18));
        personList.add(new Person1("李四", 11));
        personList.add(new Person1("王五", 17));
        //集合类Contains()，remove()方法需要自定义类覆写equals（）方法，
        //否则就调用的是Object类的equals()方法【直接比较是否为同一对象，即地址】。
        //由于引用类型或者包装类中已经覆写了Object方法所以不用在覆写equals方法。
        personList.remove(new Person1("李四", 11));
        System.out.println(personList.contains(new Person1("王五", 17)));
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
        System.out.println(personList);


    }
}
