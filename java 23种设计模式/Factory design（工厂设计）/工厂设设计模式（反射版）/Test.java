
interface Ifruit {
    void eat();
}

class Apple implements Ifruit {
    @Override
    public void eat() {
        System.out.println("eat an apple");
    }
}

class Orange implements Ifruit {
    @Override
    public void eat() {
        System.out.println("eat an orange");
    }
}

class FactoryFruit {
    public static Ifruit getInstance(String name) {
        Ifruit fruit = null;
        try {
            Class<?> cls = Class.forName(name);
            try {
                fruit = (Ifruit) cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit;
    }
}


public class Test {
    public static void main(String[] args) {
        Ifruit ifruit = FactoryFruit.getInstance("Apple");
        ifruit.eat();
    }
}
