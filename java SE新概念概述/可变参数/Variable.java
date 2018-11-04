public class Variable {
    public static void main(String[] args) {
        System.out.println(add(new int[]{1}));
        System.out.println(add(new int[]{1, 2, 3}));
        System.out.println(add(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println("可变参数___________________");
        System.out.println(add2(1, 4, 5, 6));
        System.out.println("传递多类参数——————————————————");
        System.out.println(add3("hahah", 1, 2, 3, 4, 5));

    }

    public static int add(int[] data) {
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            result += data[i];
        }
        return result;
    }

    //可变参数
    public static int add2(int... data) {
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            result += data[i];
        }
        return result;
    }

    //多类可变参数
    public static int add3(String msg, int... data) {
        int result = 0;
//        for (int i = 0; i < data.length; i++) {
//            result += data[i];
//        }
        for (int i : data) {
            result += i;
        }
        System.out.println(msg);
        return result;
    }


}
//1.可变参数
//方法的可变参数：本质上还是可变数组
//注意：如果要传递多类参数，可变参数一定放在最后，
// 并且只设置一个可变参数



