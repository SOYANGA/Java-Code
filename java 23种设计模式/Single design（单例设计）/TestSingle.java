package www.bit.java;

/**
 * 饿汉式单例：先new为敬
 */
class Singleton {

    private final static Singleton SINGLETON = new Singleton();

    private Singleton() {
    }

    //       1.饿汉
    public static Singleton getSingleton() {
        return SINGLETON;
    }
////    2.懒汉
//    public static Singleton getSingleton() {
//
//        if (SINGLETON == null) {
//            SINGLETON = new Singleton();
//        }
//        return SINGLETON;
//    }

}

public class Test {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        System.out.println(singleton);
        System.out.println(singleton1);
        System.out.println(singleton2);
    }
}
