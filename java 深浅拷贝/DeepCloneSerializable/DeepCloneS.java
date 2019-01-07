package JVMTest.DeepCloneSerializable;


import java.io.*;

class Teacher implements Serializable {
    private String name;
    private String job;

    public Teacher(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}


class Student implements Serializable {
    private String name;
    private int age;
    Teacher teacher;

    public Student(String name, int age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，
    // 而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
    @Override
    protected Student clone() {
        //可以捕获内存缓冲区的数据，转换成字节数组。
        Student student = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);//序列化
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            student = (Student) ois.readObject();//反序列化得到深度克隆结果
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return student;
        }
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }
}

public class DeepCloneS {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("铭哥", "javaTeacher");
        Student student = new Student("杨益行", 20, teacher);
        Student newstu = student.clone();
        System.out.println(newstu);
        System.out.println(newstu.getTeacher() == student.getTeacher());
    }
}

