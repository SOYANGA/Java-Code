interface ISubject {
    void buyMac();
}

class RealSubject implements ISubject {
    public void buyMac() {
        System.out.println("2.买一只Mac");
    }
}

class ProxySubject implements ISubject {
    private ISubject realsubject;

    public ProxySubject(ISubject realsubject) {
        this.realsubject = realsubject;
    }

    public void QueueUP() {
        System.out.println("1.排队买口红");
    }

    public void Express() {
        System.out.println("3.快递邮寄");
    }

    public void buyMac() {
        this.QueueUP();
        this.realsubject.buyMac();
        this.Express();
    }
}

class Factory {
    public static ISubject getInstance() {
        return new ProxySubject(new RealSubject());
    }
}

public class TestSubject {
    public static void main(String[] args) {
        ISubject subject = Factory.getInstance();
        subject.buyMac();
    }
}