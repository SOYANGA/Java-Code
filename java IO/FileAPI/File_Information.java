package FileAPI;

import java.io.File;
import java.util.Date;

public class File_Information {
    public static void main(String[] args) {
        //1.取得要操作的file文件
        File file = new File("C:" + File.separator + "Users" + File.separator + "32183" + File.separator + "Desktop" + File.separator + "公路.jpg");
        //保证是文件再进行操作
        if (file.exists() && file.isFile()) {
            System.out.println("文件大小：" + file.length());
            System.out.println("最后一次修改日期：" + new Date(file.lastModified()));
        }
    }
}
