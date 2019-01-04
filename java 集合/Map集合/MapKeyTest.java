package Maptest;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Person {
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(Integer age, String name) {

        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        return this.age.equals(person.age) &&
                this.name.equals(person.name);
    }
}


public class MapKeyTest {
    public static void main(String[] args) {
        //map中使用自定义类做为key值时需要覆写hashcode（） equals（）方法
        Map<Person, String> map = new HashMap();
        map.put(new Person(15, "张三"), "zs");
        System.out.println(map.get(new Person(15, "张三")));
    }
}
