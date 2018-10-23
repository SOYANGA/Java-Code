// import java.util.Arrays;

// public class Array {
//     public static void main(String[] args) {
//         int[] x = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
//         int[] temp = null;
//         temp = x;
//         temp[0] = 55;
//         printarr(x);
//         x = init();
//         printarr(x);
//         Arrays.sort(x);// 排序升序，内部双轴快速排序
//         printarr(x);
//         System.arraycopy(x, 0, temp, 4, 5);// 数组拷贝（源数组，原数组开始起点，目标是组，目标数组起点，拷贝长度）
//         printarr(temp);
//         x = Arrays.copyOf(temp, 10);
//         printarr(x);

//     }

//     public static int[] init() {
//         return new int[] { 5, 4, 3, 2, 1 };
//     }

//     public static void printarr(int[] temp) {
//         // for (int i = 0; i < temp.length; i++) {
//         // System.out.print(temp[i]);
//         // }
//         // System.out.println();
//         for (int x : temp) {
//             System.out.print(x + ",");
//         }
//         System.out.println();
//     }
// }

public class Array{
    public static void main(String[]args){
        int []arr=new int[]{0,1,2,3,4,5,6,7,8,9};
        for(int temp:arr){
            System.out.print(temp+",");
        }
        System.out.println();
    }
}
