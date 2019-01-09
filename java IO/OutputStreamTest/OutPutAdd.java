package InOutPutStream.OutPutStreamTest;

import java.io.*;

//文件内容追加
public class OutPutAdd {
    public static void main(String[] args) throws IOException {
        File file = new File("C:" + File.separator + "Users" +
                File.separator + "32183" + File.separator + "Desktop" +
                File.separator + "hello.txt");
        if (!file.getParentFile().exists()) {//必须保证父目录的存在
            file.getParentFile().mkdirs();//创建多级目录
        }
        //OutPutStream是一个抽象类，所以现需要通过子类进行实例化，此时只能操作File类
        OutputStream output = new FileOutputStream(file, true); //追加操作在文件输出流的构造方法后面加上true,默认是false。
        //要求输出到文件的内容
        String msg = "比特科技JAVA公开课";
        // 将内容变为字节数组
        output.write(msg.getBytes());
        //关闭输出
        output.close();
    }
}
