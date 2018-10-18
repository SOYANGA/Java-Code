class Person {
    private int age;
    private String name; // 私有
    public String country = "美国";

    public Person() {
        System.out.println("Person 类对象的产生");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }
}

class Student extends Person { // 定义一个子类
    private String school; // 扩充新的属性
    public String country = "中国";

    public Student() {
        super();
        System.out.println("Student 类对象的产生");
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() { //
        return this.school;
    }

    public void fun() {
        System.out.println("age:" + getAge()); // 隐式继承  
        System.out.println("mane:" + getName());
        System.out.println("school:" + getSchool());
        this.country = "中国";
        System.out.println(this.country);
        System.out.println(super.country);
    }

}

public class TestExtends {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("杨益行");
        student.setSchool("西安科技大学");
        student.setAge(10);
        // student.country = "中";
        student.fun();

    }
}
