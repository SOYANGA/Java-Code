class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.steAge(age);
        this.steName(name);
    }

    public String getName() {
        return this.name;
    }

    public Person steName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return this.age;
    }

    public Person steAge(int age) {
        this.age = age;
        return this;
    }

    public String toString() {
        return "姓名为：" + this.name + "\n年龄为：" + this.age;
    }
}

public class TesttoString {
    public static void main(String[] args) {
        // fun(new Person().steAge(10).steName("杨益行"));
        fun(new Person("杨益行",100));

    }

    public static void fun(Object ob) {
        System.out.println(ob.toString());
    }
}