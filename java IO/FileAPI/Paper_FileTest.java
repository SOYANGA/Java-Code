package FileAPI;

import java.io.File;
import java.io.IOException;

//1.取得File对象。
//2.判断父路径是否存在，不存在创建多级父路径。
//3.判断文件是否存在，不存在则创建。
public class Paper_FileTest {
    public static void main(String[] args) throws IOException {
        //1.取得File对象。
        File file = new File("C:" + File.separator + "Users" + File.separator + "32183" + File.separator + "Desktop" + File.separator + File.separator + "javaIO" + File.separator + "bit" + File.separator + "TestIO.java");
        //2.判断父路径是否存在，不存在创建多级父路径。
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();//递归式创建多级目录，有多少多级目录就创建多少
        }
        //3.判断文件是否存在，不存在则创建。
        if (file.exists()) {
            //文件存在,进行删除
            file.delete();
        } else {
            file.createNewFile();
        }
    }
}
