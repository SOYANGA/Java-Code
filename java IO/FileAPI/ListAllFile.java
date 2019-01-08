package FileAPI;

import java.io.File;
import java.lang.reflect.Field;

public class ListAllFile {
    public static void main(String[] args) {
        new Thread(() -> {
            File file = new File("C:" + File.separator + "Users" + File.separator + "32183" + File.separator + "Desktop");
            long start = System.currentTimeMillis();
            listAllFiles(file);
            long end = System.currentTimeMillis();
            System.out.println("共耗时：" + (end - start) + "ms");
        }, "输出线程").start();
        System.out.println("开始进行文件输出....:)");

    }


    public static void listAllFiles(File file) {
        if (file.isDirectory()) {//判断现在给定的file对象是一个目录
            File[] result = file.listFiles();//继续列出子目录内容
            if (result != null) {
                for (File file1 : result) {
                    listAllFiles(file1);
                }
            }
        } else {
            //给定的file是一个文件，直接打印
            System.out.println(file);
        }
    }
}

