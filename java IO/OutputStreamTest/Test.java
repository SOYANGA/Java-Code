package OutputStreamTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


class CloseTest implements  AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("自动调用close方法");
    }
    public void fun(){
        System.out.println("普通方法");
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
//        //1.取得终端对象
//        File file = new File("C:" + File.separator + "Users" + File.separator
//                + "32183" + File.separator + "Desktop" + File.separator + "TestHello.txt");
//        //2.取得指定对象的输出流
//        OutputStream outputStream = new FileOutputStream(file, true);
//        //3.进行数据的输出
//        String str = "Hello World\r";
//        outputStream.write(str.getBytes(), 6, 6);
//        outputStream.close();
////        outputStream.flush();
        try(CloseTest closeTest =new CloseTest()){
                closeTest.fun();
        }catch(Exception e){

        }
    }
}
