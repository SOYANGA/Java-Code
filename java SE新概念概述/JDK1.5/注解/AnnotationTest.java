class Person {
    //由于输出错误导致覆写失败
    @SuppressWarnings({"tostring", "unused"})
    public String tostring() { //现在希望对toString（）方法覆写 大写S
        return "小比特们";
    }

    //这时候不叫做覆写，属于自己定义了一个扩展方法，最为重要的是，这个问题在程序编译的根本
    //无法显示出。为了保证覆写方法严格，可以使用一个注解@Override来检测；如果该方法确定成功覆写
    //则不会有语法错误；如果没有成功覆写，则认为语法错误。
    @Override  //追加注解以后明确的表示方法是一个覆写的方法，如果覆写错误会现语法错误
    public String toString() {
        return "Person{}";  //此时覆写成功
    }

    @Deprecated
    public void fun() {
    }//明确标记该方法不推荐用户使用已经过期了。
}


public class AnnotationTest {
    @SuppressWarnings({"rawtypes", "unused"})
    public static void main(String[] args) {
        System.out.println(new Person());
        new Person().fun();  //表示该方法已经过期不推荐使用
    }
}
//一、注解（Annotation）
//JDK提供的三个注解 ：@Override、@Deprecated、@SupperssWarnings
//1.1准确覆写(@Override)
//方法覆写：发生在继承关系之中，子类定义了与父类方法名称相同、参数列表相同、
//返回值类型相同成为方法的覆写，被覆写的方法不能够拥有比父类更为严格的访问控制
//权限。

//1.2声明过期处理：@Deprecated
//如果现在有一个程序类，从项目1.0到99.0版本一直都在使用者，但是从100.0版本后发现该程序
//可能会产生问题，那么这个时候不能删除这个类一个，绝不能删除，因为其他旧版本还在使用这个
//类，并且这个类在旧版中没有问题，这个时候希望在进行新版本扩展的时候不再去使用这个不建议
//的类，所以加一个过期注释@Deperecated

//过期处理工具往往出现在一些平台上支持的工具上，例如：JDK就是一个平台，所以子啊JDK中很多方法
//都推荐用户不再使用了

//1.3压制警告（@SuppressWarnings）

//当调用了某些操作可能产生问题的时候就会出现警告进行，但警告信息并不是错，这个时候又不想总提示警告
//这个时候可以使用压制警告。
//Java还支持自定义注解。





