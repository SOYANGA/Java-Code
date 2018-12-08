package FileAPI;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
        File file = new File("C:" + File.separator + "Users" + File.separator + "32183" + File.separator + "Desktop");
        new Thread(() -> {
            long start = System.currentTimeMillis();
            listAllFiles(file);
            long end = System.currentTimeMillis();
            System.out.println("桌面文件遍历结束耗时为:" + (end - start));
        }).start();
        System.out.println("main线程结束！");
    }

    public static void listAllFiles(File file) {
        if (file.isFile()) {
            System.out.println(file);
        } else {
            if (file.exists() && file.isDirectory()) {
                File[] files = file.listFiles();
                for (File file1 : files) {
                    listAllFiles(file1);

                }
            }
        }
    }
}
