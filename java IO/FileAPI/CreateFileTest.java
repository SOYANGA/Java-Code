package FileAPI;

import javax.xml.transform.Source;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

public class CreateFileTest {
    public static void main(String[] args) {
        File file = new File("C:" + File.separator + "Users" + File.separator
                + "32183" + File.separator + "Desktop" + File.separator
                + "www" + File.separator + "bit" + File.separator + "java" + File.separator + "TestIO.java");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        if (file.exists()) {
            System.out.println("文件已存在!");
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
