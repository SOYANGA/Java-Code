package SetTest;


import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

//1.TreeSet排序，或自定义类要想存储在TreeSet中，必须是是实现比较器
//1.内部比较器实现Compareable接口并且覆写其方法（Compareto()）
class People implements Comparable<People> {
    private String name;
    private Integer age;

    public People(String name, Integer age) {
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

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(People o) {
        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return this.name.compareTo(o.name); //String类本身就已经是需西安Comparable接口
        }
    }
}

class PeopleComparator implements Comparator<People> {
    @Override
    public int compare(People o1, People o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        } else if (o1.getAge() < o2.getAge()) {
            return -1;
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}

public class TreeSetSort {
    public static void main(String[] args) {
        //1.内部比较器（可以自定义比较策略）自定义类中是实现Comparable接口
        Set<People> set1 = new TreeSet<>();
        set1.add(new People("张三", 20));
        //重复元素
        set1.add(new People("张三", 20));
        set1.add(new People("李四", 20));
        set1.add(new People("王五", 19));
        System.out.println(set1);


        //2.外部比较器（在自定义类的外部自己是实现Comparator接口）
        PeopleComparator peopleComparator = new PeopleComparator();
        Set<People> set2 = new TreeSet<>(peopleComparator);
        set1.add(new People("张三", 20));
        //重复元素
        set1.add(new People("张三", 20));
        set1.add(new People("李四", 20));
        set1.add(new People("王五", 19));
        System.out.println(set1);


    }
}
