public class ArrStatis {
    public static void main(String[] args) {
        processData(new int[] { 1, 4, 3, 4, 55, 77, 6, 9, 8 });
    }

    public static void processData(int[] temp) {
        double[] result = new double[4];
        result[0] = temp[0];// max
        result[1] = temp[1];// min
        result[2] = temp[2];// sum
        result[3] = temp[3];// avg
        for (int i = 0; i < temp.length; i++) {
            result[2] += temp[i];
            if (temp[i] > result[0]) {
                result[0] = temp[i];
            }
            if (temp[i] < result[0]) {
                result[1] = temp[i];
            }
        }
        result[3] = result[2] / temp.length;
        System.out.println("最大值："+result[0]);
        System.out.println("最小值："+result[1]);
        System.out.println("总和为："+result[2]);
        System.out.println("平均值："+result[3]);
    }
}