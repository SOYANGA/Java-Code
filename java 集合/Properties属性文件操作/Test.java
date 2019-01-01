package PropertiesTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\32183\\Desktop\\DBCOafig.properties");
        Properties properties = new Properties();
//        properties.setProperty("User", "root");
//        properties.setProperty("passWord", "123");
//        properties.store(new FileOutputStream(file), "数据库的用户名与密码");
        properties.load(new FileInputStream(file));
        System.out.println(properties.getProperty("User"));
        System.out.println(properties.getProperty("passWord"));


    }
}
