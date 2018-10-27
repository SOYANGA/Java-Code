import java.lang.reflect.Proxy;

interface ISubject {
    void buyComputer();
}

class ReallSubject implements ISubject {
    public void buyComputer() {
        System.out.println("2.买一台外星人电脑");
    }
}

class ProxySubject implements ISubject {
    private ISubject realsubject;

    public ProxySubject(ISubject realsubject) {
        this.realsubject = realsubject;
    }

    public void produceComputer() {
        System.out.println("1.生产外星人电脑");
    }

    public void afterSale() {
        System.out.println("3.外星人电脑售后团队");
    }

    public void buyComputer() {
        this.produceComputer();// 真实操作前的准备
        this.realsubject.buyComputer();// 调用真实业务
        this.afterSale();// 操作后的收尾
    }
}

public class Subject {
    public static void main(String[] args) {
        ISubject subject = new ProxySubject(new ReallSubject());
        subject.buyComputer();
    }
}