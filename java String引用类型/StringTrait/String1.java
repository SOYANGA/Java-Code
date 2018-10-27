public class String1 {
    public static void main(String[] args) {
        System.out.println("1________________________");
        // 一、String类的两种实例化话方法
        // 1.直接赋值
        String str1 = "hello";// str 是一个对象，那么"hello"就应该在对内存当中
        System.out.println(str1);
        // 2.传统方法  
        String str2 = new String("hello");
        System.out.println(str2);

        System.out.println("2________________________");

        // 二、字符串相等的比较
        // 错误的比较
        String str3 = "Hello";
        String str4 = new String("Hello");
        System.out.println(str3 == str4); // false
        // 原因
        // str3和str4 == 比较的是对象（栈内存地址）
        // 使用equals方法比较字符串内容
        String str5 = "Hello";
        String str6 = new String("Hello");
        System.err.println(str5.equals(str6));// true

        System.out.println("3________________________");

        // 三、字符串常量是String的匿名对象
        String str7 = "Hello";
        String str8 = new String("Hello");
        System.out.println(str7.equals(str8)); // true
        System.out.println("Hello".equals(str8));// true //用这种方法避免如下情况
        // eg:
        // String str = null;
        // System.out.println(str.equals("hello")); 空对象空指针异常（NullpointerException）

        System.out.println("4________________________");

        // 四、String 类两种实例化的区别
        // 观察下列代码总结：
        // 1.直接赋值
        String string1 = "hello";
        String string2 = "hello";
        String string3 = "hello";
        System.out.println(string1 == string2); // ture
        System.out.println(string2 == string3);// true
        System.out.println(string1 == string3);// true

        /**
         * 总结：上面知道字符串常量是一个String匿名对象 String类的设计采用了共享设计模式
         * 在JVM底层实际上会自动维护一个对象池（字符串对象池），如果现在采用了直接赋值
         * 的模式进行String类的对象实例化操作，那么该实例化对象（字符串内容）将自动保存
         * 到这个对象池中去。如果下次继续所使用直接赋值的模式声明String类对象，此时对象
         * 池中若有指定的内容，将直接进行引用；若没有，则开辟新的字符串对象而后将其保存在 对象池之中以供 
         * 
         * 
         * 
         * 所谓的对象池其实就是一个对象数组（目的就是减少开销）
         * 
         */

        // 2.采用构造方法
        String string4 = new String("hello");
        System.out.println(string4 == string1);// false

        /**
         * String的构造方法就会开辟两块堆内存空间执行先遇到是一个常量（String类的匿名对象)
         * 则按照String类采用的共享设计则会开辟一块空间为（"Hello"）但向左执行
         * 又遇到了String的构造方法（new了一个String的类）将String4对象（栈内存）
         * 的指向指向新开辟的一块堆内存（开辟的第二块堆内存空间）
         * 则第一块开辟开辟的字符串常量内存则就会变成没有栈内存指向的垃圾空间
         *
         * 且经过这种方法创建的的字符串常量并没有保存在对象池当中 得进过手动入池
         * 
         * 如下：就是手工入池操作   pub  inne )
         * 
         * 
         */
        String string5 = new String("hello").intern();
        System.out.println(string5 == string1);// true

        // 大总结：请解释String类中的两种对象实例化的区别
        // 1.直接赋值：只会开辟一块堆内存空间，并且该字符串对象
        // 可以自动保存在对象池中以供下次使用
        // 2.构造方法：会开辟两块堆内存空间，其中一块成为垃圾空间，不会自动保存在
        // 对象池当中，可以使用intern()方法手工入池
        // 因此我们一般会采用第一种方式即直接赋值。

        System.out.println("5________________________");

        // 五、字符串常量不可变更
        // 字符串一旦定义不可变更，所有语言对于字符串的底层实现，都是字符数组，数组的最大缺陷
        // 就是长度固定，在定义字符串常量时，它的内容不可改变
        // 如下代码：
        String string6 = "hello";
        string6 = string6 + "world";
        string6 += "!!!";
        System.out.println(string6); // hello world !!!
        //解释：
        // 一下变更的不是 字符串String6第一次赋值"hello"的内容
        //字符串一旦定义不能变更
        //而变更的是 字符串对象的变更而非字符串常量
        //即：字符串没有发生任何变化，但是字符串对象的引用一直在改变，
        //而且会产生大量的垃圾空间。正式因为String的特点，所以不要试图给字符串执行+操作
        //如果改行代码被多个用户执行同样的操作，那么产生的垃圾数量就相当可观了。
        

        //定下以下原则：
        //1.字符串使就采用直接赋值
        //2.字符串比较就使用equals()实现
        //3.字符串别改变太多
    }
}