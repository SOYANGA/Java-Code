//Object是Java默认提供的一个类。Java里面除了Object类，所有的类都存在继承关系。
//默认会继承Object父类。即，所有类的对象都可以使用Object进行比较
//1.Object接受所有类的对象
//所以在开发中Object类是参数的最高同一类。
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "姓名" + this.name + "年龄" + this.age;
    }

    @Override//对象之间的比较
    public boolean equals(Object object) {
        if (object == null) { //对象不为空
            return false;
        }
        if (object == this) { //本对象
            return true;
        }
        //不是Person类对象
        if (!(object instanceof Person)) {
            return false;
        }
        Person person = (Person) object; //向上转型 ，比较对象属性
        return this.name.equals(person.name) && this.age == person.age;
    }
}

class Student {
}

public class TestObjectClass {
    public static void main(String[] args) {
        //1/2.1
        System.out.println("1/2.______________________");
        fun(new Person("yuisama", 25));
        fun("hello");
        Student student = new Student();
        fun(student);
        //2.2.
        System.out.println("3.______________________");
        String msg = "Hello" + new Person("SOYANGA", 20);
        System.out.println(msg);
        //3.
        System.out.println("4.______________________");
        Person per1 = new Person("SOYANGA", 20);
        Person per2 = new Person("SOYANGA", 20);
        System.out.println(per1.equals(per2));
    }

    public static void fun(Object obj) {
        System.out.println(obj.toString());
// 等同于System.out,println(obj);
        //默认输出对象,调用的就是toString()方法
    }

}
//2.1取得对象信息
//在使用对象直接输的时候，默认输出的是"类名@对象地址的编码"。如果现在使用的都是
//String类，该类对象直接输出的是内容，主要原因就是toString()方法的问题
//原因：String类覆写了（其父类）Object中的toString方法

//通过上面的代码发现，默认Object类提供的toString方法只能够得到一个对象的地址
//（而这是所有对想想都共同具备的特征）。如若接的默认给出的toString()方法功能不足
//就需要在子类上覆写toString()方法。

//eg:子类 Student 覆写 toString()方法


//2.2.toString的核心在于取得对象信息
//String作为信息输出的重要类型，在Java中所有的数据类型只要遇见了String并且执行了“+”
//那么都要求其将变为字符串后的连接，而所有对象要变为字符串就默认使用toString()方法

//3
//String类对象比较使用的是equals（）方法，实际上String类的equals（）方法就是覆写的
//Object类在中的equals（）方法。
//结论：字符串是爸爸




