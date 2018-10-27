public class StringMethod {
    public static void main(String[] args) {
        System.out.println("\n1.1_________________________");

        // 一、 字符与字符串
        // 字符串就是一个字符数组，所以在String类里面
        // 支持有字符数组和字符串之间的相互转换的操作方法
        // 1.字符串变为字符数组
        String str = "HelloWorld";
        char[] data = str.toCharArray();
        for (char temp : data) { // 这里要使用char
            System.out.println(temp + ",");
        }

        System.out.println("\n1.2_________________________");

        // 2.字符数组转换为字符串
        System.out.println(new String(data));// HelloWorld (全转换)
        System.out.println(new String(data, 5, 5)); // World（部分转换）

        System.out.println("\n1.3_________________________");

        // 3.不常用（将字符串中 一个字符 转换为字符数组）
        System.out.println(str.charAt(0));// H
        System.out.println(str.charAt(1));// e
    }
}
