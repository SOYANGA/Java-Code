public class TestString {
    public static void main(String[] args) {
        String str = new String("Hello" + "World" + "!!!");
        System.out.println(str);
        System.out.println("_______________________");
        // 验证：
        String str1 = new String("Hello" + "World" + "!!!").intern();

        String str2 = "Hello";
        String str3 = "HelloWorld";
        String str4 = "!!!";
        String str5 = "World";
        String str6 = "HelloWorld!!!";
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
        System.out.println(str1 == str5);
        System.out.println(str1 == str6);
        int u = 0;
        String str8 = null;
    }
}
// 开辟了几个空间 分别是什么 空草图间图如何画
// 从右向左 字符串常量不可被更改
// 所以 并没有更改其中任何一个字符串常量
//
// 先执行（）里的内容 即：分别依次开辟了： Hello World HelloWorld !!!（前4个都是垃圾空间）
// HelloWord!!!（最后一个也是垃圾空间，并不是str指向的堆内存的）
//
// 然后执行 new String 操作给实例化str 给str的构造方法中传参数（HelloWorld!!!） 开辟一个属于Stri
// g
// str（对象）的堆内存空间其内容为：HelloWorld!!!
// 总结：总共开辟了6个空间 且5个垃圾空间 还没有入对象池

// 验证：一下手工入池以后查看 入的是哪个字符串常量的值：
// 结果为：入的是String str 中的值:HelloWorld!!!