public class forEach {
    public static void main(String[] args) {
        System.out.println("foreach循环————————————————————");
        print(1, 2, 3, 6, 4, 5);
    }
    //foreach循环（增强型for循环）
    public static void print(int... data) {//原始数组
        for (int i : data) { //将数组中的每个元素都赋值给i
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
//2.foreach循环
//只用于数组、类集内容的取得，不能修改原数组、类集内容

//for(数据类型 临时变量 : 数组(集合)•)
// { // 循环次数为数组长度，
// 而每一次循环都会顺序取出数组中的一个元素赋值给临时变量
// }

//从前到后把值拷贝给temp,并操作temp
//相当于在for循环无须用索引只来取出数据