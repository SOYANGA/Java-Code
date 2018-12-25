package SetTest;

//自定义类使用Hashset必须要覆写hashCode()与equals()
// 方法消除重复


//暂定它为Object类的两步走策略：
//1.第一步要通过一个对象的唯一编码找到一个对象的信息
//当编码匹配之后再调用equals（）方法。

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student {
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        Student student = (Student) o;
//        return Objects.equals(name, student.name) &&
//                Objects.equals(age, student.age);
//    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return false;
        } else if (obj == null) {
            return false;
        } else if (!(obj instanceof Student)) {
            return false;
        }
        Student student = (Student) obj;//向上转型
        return this.age.equals(student.age) &&
                this.name.equals(student.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age); //默认使用对象的地址取哈希值（object类）
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class HashSetRepetition {
    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();
        //只是判断重复性，所以hashcode，和equals方法就好了。
        set.add(new Student("傅婕", 20));
        set.add(new Student("杨益行", 20));
        //重复元素
        set.add(new Student("李四", 20));
        set.add(new Student("李四", 20));
        set.add(new Student("王五", 19));
        set.add(new Student("王五", 19));
        System.out.println(set);
    }
}
