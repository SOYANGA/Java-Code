//在Java里，针对于可能出现的公共的程序问题都会提供有相应的异常信息，
// 但是很多时候这些异常信息往往不够我 们使用。
// 例如，现在有需求：在进行加法运算时，如果发现两个数相加内容为50，
// 那么就应当抛出一个 AddException异常。这种异常Java不会提供，
// 所以就必须定义一个属于自己的异常类。
//自定义异常类可以继承两种父类：Exception、RuntimeException。
public class CustomException {
    public static void main(String[] args) throws Exception {
        int num1 = 20;
        int num2 = 30;
        if (num1 + num2 == 50) {
        throw new AddException("错误得相加操作");
        }
        }
        }

class AddException extends Exception {
    public AddException(String msg) {
        super(msg);
    }
}
