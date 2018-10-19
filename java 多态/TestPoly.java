class Person {
    public void print() {
        System.out.println("1.我是爸爸");
    }
}

class Student extends Person{
    public void print() {
        super();//对super的调用必须是构造器中的第一个语句  调用无参时可以省略，调用有参
        System.out.print("2.我是儿子");
    }
}

public class TestPoly {
    public static void main(String[] args) {
        Person per = new Student();
        per.print();
    }
}