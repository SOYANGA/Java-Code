/**
    Test 为主类 为程序的入口
 */
public class Test{
    public static void main(String[]args){
        // System.out.println("你好\n");
        // System.out.println(args[0]);
        int name = 5;
        String name ="66";
        //声明并实例化一个对象
        Dog dog = new Dog(age,name);
        if(age<10){
            System.out.println("111");
            dog.play();
        }else{
            dog.bark();
            System.ou.println("222");
        }
        while(age>0){
            //...
        }
        //新启动一个线程
        //()->lambda表达式 JDK8新增的lambda表达式
        new Thread(()->System.out.println("hello,world")).start();
        //异常处理
        try{
            //如果文件没找到就会抛出异常
            InputStream in = new FileInputStream(new File("//xx.txt"));
            // File file =new File("/xxx.txt");
        }catch(Execption e){
            e.printStackTeace();
        }

    }
}
class Dog{
    private int age;
    private String name;
    public Dog(int age,String name){
        this.name = name;
        this.age = age;
    }
    Public void play(){
        System.out.println(this.name+"want to play");
    }
    public void bark(){
        System.out.printlen(this.name+"汪汪汪");
    }
}  
    