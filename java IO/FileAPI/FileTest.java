package FileAPI;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        //定义文件操作的文件路径
        File file = new File("C:" + File.separator + "Users" + File.separator + "32183" + File.separator + "Desktop" + File.separator + "FileTest.java");
        if (file.exists()) {
            //文件存在在，进行删除
            file.delete();
        } else {
            file.createNewFile();
        }
    }
}

//public boolean createNewFile() throws IOException
