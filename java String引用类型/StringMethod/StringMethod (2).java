package StringMethod.Test;

import StringMethod.Test.FirstUpper;

public class StringMethod {
    public static void main(String[] args) {
        System.out.println("\n1.1_________________________");

        // 一、 字符与字符串
        // 字符串就是一个字符数组，所以在String类里面
        // 支持有字符数组和字符串之间的相互转换的操作方法
        // 1.字符串变为字符数组
        String str1 = "HelloWorld";
        char[] data1 = str1.toCharArray();
        for (char temp : data1) { // 这里要使用char
            System.out.print(temp + ",");
        }

        System.out.println("\n\n1.2_________________________");

        // 2.字符数组转换为字符串
        System.out.println(new String(data1));// HelloWorld (全转换)
        System.out.println(new String(data1, 5, 5)); // World（部分转换）

        System.out.println("\n1.3_________________________");

        // 3.不常用（将字符串中 一个字符 转换为字符数组）
        System.out.println(str1.charAt(0));// H
        System.out.println(str1.charAt(1));// e


        //二、字节与字符串
        //字节常用于数据传输以及编译转换的处理当中，在String中提供对字节转换的支持
        System.out.println("\n2.1_________________________");

        //1.字符串变为字节数组（成员方法）
        String str2 = "helloworld";
        byte[] data2 = str2.getBytes();
        for (byte temp : data2) {
            System.out.print(temp + ",");
        }
        System.out.println();

        System.out.println("\n2.2_________________________");
        //2.字节数组变为字符串 (构造方法)
        System.out.println(new String(data2));

        //三、字符串比较
        //1.区分大小写的比较

        System.out.println("\n3.1_________________________");
        String str3_1 = "hello";
        String str3_2 = "Hello";
        System.out.println(str3_1.equals(str3_2));

        System.out.println("\n3.2_________________________");
        //2.不区分大小写的比较
        System.out.println(str3_1.equalsIgnoreCase(str3_2));

        System.out.println("\n3.3_________________________");
        //3.你叫两个字符串的大小关系
        //>0 ： 本字符串大于目标字符串
        //=0 ： 本字符串等于目标字符串
        //<0：   本字符串小于目标字符串
        System.out.println("A".compareTo("a")); //-32
        System.out.println("A".compareTo("A")); //0
        System.out.println("a".compareTo("A")); //32
        //注意：compareTo只返回两个数组中第一个不一样数组的差值(其后的不再比较)
        System.out.println("aBcd".compareTo("abCD"));//只比较第B 和 b//-32

        //四、字符串查找
        //从一个完整的字符串查找（判定）指定内容是否存在

        System.out.println("\n4.1_________________________");
        //1.最常用的就contain() JKD1.5以后追加的
        String str4 = "helloworld";
        System.out.println(str4.contains("world"));  //true

        System.out.println("\n4.2_________________________");
        //2.JDk1.5之前使用indexOf();方法
        System.out.println(str4.indexOf("world"));//返回的查找的位置的下标 5
        System.out.println(str4.indexOf("bit"));//如果没有找到则返回-1
        if (str4.indexOf("hello") != -1) {
            System.out.println("可以查看到指定字符串");
        }
        //注意：如果使用indexOf（）则它只能返回查找到的第一个位置的下标
        //eg：
        System.out.println(str4.indexOf("l")); //2
        System.out.println(str4.indexOf("l", 5));//8
        System.out.println(str4.lastIndexOf("l"));//从后向前查找 // 8

        System.out.println("\n4.2_________________________");
        //3.判断开头或结尾
        String str4_3 = "@@helloworld!!";
        System.out.println(str4_3.startsWith("@@"));//true
        System.out.println(str4_3.startsWith("**"));//false
        System.out.println(str4_3.endsWith("!!"));//true

        System.out.println("\n5.__________________________");
        //五、字符串的替换
        String str5 = "helloworld";
        System.out.println(str5.replaceAll("l", "_"));
        System.out.println(str5.replaceFirst("o", "*"));

        //六、字符串拆分
        //可以将一个完整的字符串按照指定的分割符划分为若干个子字符串
        System.out.println("\n6.1__________________________");
        //1.整个字符串拆分
        String str6 = "hello world hello bit";
        String[] result1 = str6.split(" ");//按照空格拆分
        //返回值是一个字符串数组 长度为按指定符号拆分的字符串个数
        for (String s : result1) {
            System.out.println(s);
        }

        System.out.println("\n6.2__________________________");
        //2.字符串的部分拆分
        String[] result2 = str6.split(" ", 2);
        for (String s : result2) {
            System.out.println(s);
        }
        //注意：拆分的是按照第n-1个出现指定符号，为界限拆分为指定个数的
        //且特殊字符需要进行转义 eg：//.

        System.out.println("\n7.__________________________");
        //七、字符串的截取
        //从一个完整的字符串中截取出部分内容
        //1.从指定索引位置开始截取到结尾
        String str7 = "helloworld";
        System.out.println(str7.substring(5)); //world
        System.out.println(str7.substring(0, 5));//hello


        //八、字符串的其他操作

        System.out.println("\n8.1__________________________");
        //1.去掉字符串的左右空格，保留中间空格
        String str8 = " Hello World ";
        System.out.println("[" + str8 + "]");
        System.out.println("[" + str8.trim() + "]");

        System.out.println("\n8.2__________________________");
        //2.字符大小写转换
        //转大写
        System.out.println(str8.toUpperCase());
        //转小写
        System.out.println(str8.toLowerCase());
        //注意：这两个方法只能转换字母

        System.out.println("\n8.3__________________________");
        //3.得到字符串的长度
        System.out.println(str8.length());  //13

        System.out.println("\n8.4__________________________");
        //4.判断字符串是否为空
        System.out.println("hello".isEmpty());//false
        System.out.println(" ".isEmpty());//false
        System.out.println(new String().isEmpty()); //引用类型的默认值为null

        System.out.println("\n8.5__________________________");
        //5.首字母大写方法
        System.out.println(FirstUpper.firstUpper("hahaha"));
        System.out.println(FirstUpper.firstUpper(""));
        System.out.println((FirstUpper.firstUpper("a")));
    }
}
