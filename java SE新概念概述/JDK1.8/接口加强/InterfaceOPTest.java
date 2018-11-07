//定义普通方法
interface IMessage {
    public default void fun() { //追加了普通方法，有方法体
        System.out.println("Hello IMessage");
    }

    //可以直接由接口名称直接调用
    public static IMessage getInstance() {
        return new MessageImpl();
    }

    public void print();
}

class MessageImpl implements IMessage {
    @Override
    public void print() {
        System.out.println("Hello MessageImpl");
    }
}


public class InterfaceOPTest {
    public static void main(String[] args) {
        IMessage message = new MessageImpl();
        message.print();
        message.fun(); //该普通方法直接被接口子类继承
        IMessage message1 = IMessage.getInstance();  //通过接口名直接调用
        System.out.println(message1);
        message1.fun();


    }
}
//接口加强    JDK1.8
//为了解决长时间用接口且子类众多，发现缺少一个方法（添加之），所有子类则都需将这个方法
//重新实现一下，太耗费时间。
//为了解决这个问题JDK1.8开始，转我们提供了两个类的新结构。

//1.可以使用default来定义普通方法，需要通过对象调用。

//2.可以使用static来定义静态方法，通过接口名字九合一调用。
