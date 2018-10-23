public class ObjectArr{
    public static void main(String[] args){
        Person[] per = new Person[3]; // 数组动态初始化，每个元素都是其对应数据类型的默认值 
        per[0] = new Person("小杨",20);
        per[1] = new Person("阿婕",20);
        per[2] = new Person("慕婕",0);
        for (int i = 0; i < per.length; i++){
            per[i].getInfo();
        }
    }

    class Person{
        private String name;
        private int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public void getInfo(){
            System.out.println("姓名:"+this.name+"年龄:"+this.age);
    }
}
}