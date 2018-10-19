// class Person {
//     public String info = "Person";

//     public void fun() {
//         this.print();
//     }

//     public void funs() {
//         System.out.println("1.Person类的funs方法");
//     }

//     private void print() {
//         System.out.println("1.Person类的print方法");
//     }
//     // 如果父类方法使用private定义，那就表示这个方法不能被覆写，只能父类使用，
//     // 及子类根本就不知道父类有这样的方法
// }

// class Student extends Person {
//     // 该方法只是子类新定义的方法而已 不是方法覆写
//     public String infoe = "Student";

//     public void print() {
//         super.funs();
//         System.out.println("2.Student类的print方法");
//     }

//     // 方法覆写
//     public void funs() {
//         System.out.println("2.Student类的funs方法");
//     }
// }

// public class Override {
//     public static void main(String[] args) {
//         Student stu = new Student();
//         Person per = new Person();
//         stu.print();
//         stu.funs();

//         per.fun();
//         per.funs();
//     }

// }
// // 访问控制权限private<default<public

///////////////////////////

