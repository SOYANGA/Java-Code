class Person1 {
    private String name;
    private int age;

    public Person1(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public boolean equals(Object object) {
        // 1.判断是不是一个类的对象
        if (!(object instanceof Person1)) {
            return false;
        }
        // 2.判断是不是一个对象 堆地址是否相同 
        if (this == object) {
            return true;
        }
        //3.向下转型，
        //取出属性进行比较
        Person1 per = (Person1) object;
        return (this.name.equals(per.name)) && (this.age == per.age);
    }
}

public class ObjectEquals {
    public static void main(String[] args) {
        Person1 per1 = new Person1("张三", 20);
        Person1 per2 = new Person1("张三", 20);
        System.out.println(per1.equals(per1));
    }
}