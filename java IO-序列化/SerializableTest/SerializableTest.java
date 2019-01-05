package SerializableTest;

import java.io.*;

class Person implements Serializable {
    private String name;
    private transient Integer age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class SerializableTest {
    public static void main(String[] args) throws Exception {
        //序列化
        File file = new File("C:\\Users\\32183\\Desktop\\test8.java");
//        OutputStream out = new FileOutputStream(file);
//        Person per = new Person("蛋哥", 40);
//        ObjectOutputStream outputStream = new ObjectOutputStream(out);
//        outputStream.writeObject(per);
//        outputStream.close();

        //反序列化
        InputStream in = new FileInputStream(file);
        ObjectInputStream inputStream = new ObjectInputStream(in);
        Person newperson = (Person) inputStream.readObject();
        System.out.println(newperson);

    }
}

