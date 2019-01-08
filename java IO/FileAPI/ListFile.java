package FileAPI;

import java.io.File;

public class ListFile {
    public static void main(String[] args) {
        //要操作的文件
        File file = new File("C:" + File.separator + "Users" + File.separator + "32183" + File.separator + "Desktop");
        //保证是一个目录
        if (file.exists() && file.isDirectory()) {
            //列出目录下的全部内容
            File[] result = file.listFiles();
            for (File file1 : result) {
                System.out.println(file1);
            }
        }

    }
}
