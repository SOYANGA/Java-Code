package child;

import father.Father;

public class Child extends Father{
    public void print(){
        System.out.println(super.msg);
    }
}
