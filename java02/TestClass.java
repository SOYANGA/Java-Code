public class TestClass {
    public static void main(String[] args) {
        Person per1 = new Person();
        per1.name = "杨益行";
        int i = 18;
        per1.setAge(i);
        per1.eat();
        per1.sleep();
        per1.work();
    }
}

class Person {

    public String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int i) {
        this.age = i;
    }

    public void eat() {
        System.out.println(this.name + "吃饭");
    }

    public void sleep() {
        System.out.println(this.name + "睡觉");
    }

    public void work() {
        if (this.age >= 22) {
            System.out.println(this.name + "还在上学");
        } else {
            System.out.println(this.name + "工作");
        }
    }
}
