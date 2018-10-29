public class TestSignle {
    public static void main(String[] args) {
        try {
            //可能出现异常的语句
            System.out.println("2.shuxain1" + (10 / 0));
        } catch (Exception e) {
            //向上转型 Exception类可以调用对应错误类的printStackTrace方法
            //出现异常后走catch块，决定如何处理
            //出错后打印异常的堆栈
            e.printStackTrace();
            System.out.println("sadhkasjhd");
        } finally {
            //无论如何都会程序最终都会走到这里
            System.out.println("dasdsa");
        }
    }
}
