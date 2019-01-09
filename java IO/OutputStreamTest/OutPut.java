package InOutPutStream.OutPutStreamTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//文件内容覆盖
public class OutPut {
    public static void main(String[] args) throws IOException {
        File file = new File("C:" + File.separator + "Users" +
                File.separator + "32183" + File.separator + "Desktop" +
                File.separator + "hello.txt");
        if (!file.getParentFile().exists()) {//必须保证父目录的存在
            file.getParentFile().mkdirs();//创建多级目录
        }
        //OutPutStream是一个抽象类，所以现需要通过子类进行实例化，此时只能操作File类
        OutputStream output = new FileOutputStream(file);
        //要求输出到文件的内容
        String msg = "比特科技JAVA公开课";
        // 将内容变为字节数组
        //1.全输出
//        output.write(msg.getBytes());
        //2.部分输出
        output.write(msg.getBytes(), 0, 6); //比特
        //关闭输出
        output.close();
    }
}
//在进行文件输出的时候，所有的文件会自动帮助用户创建，不在需要调用createFile()方法手工创建。
//这个时候程序如果重复执行，并不会出现内容追加的情况而是一直在覆盖。如果需要文件内容追加，
// 则需要调用 FileOutputStream提供的另外一种构造方法。