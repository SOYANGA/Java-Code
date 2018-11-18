
class Element {
    private int count = 1;
    public boolean flag = true;
    private Integer num = 1;
    private Character letter = 'A';

    //每一次
    public synchronized void setNum() {
        if (count % 3 == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(letter>'Z'){
            System.out.print("\n打印完毕，没有死锁！");
        }else{
            System.out.print(num++);
            System.out.print(num++);
            count += 2;
            //唤醒打印子母类
            notify();
        }
    }

    public synchronized void setLetter() {
        if (count % 3 != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(letter++);
        count++;
        if (letter > 'Z') {
            flag = false;
        }
        //唤醒打印数字类
        notify();
    }
}


//打印数字类
class PrintNum implements Runnable {
    Element element;

    public PrintNum(Element element) {
        super();
        this.element = element;
    }

    @Override
    public void run() {
        while (element.flag) {
            this.element.setNum();
        }
    }
}

//打印子母类
class PrintLetter implements Runnable {
    Element element;

    public PrintLetter(Element element) {
        super();
        this.element = element;
    }

    @Override
    public void run() {
        while (element.flag) {
            this.element.setLetter();
        }
    }
}


public class Test1 {
    public static void main(String[] args) {
        Element element = new Element();
        PrintNum printNum = new PrintNum(element);
        PrintLetter printLetter = new PrintLetter(element);

        Thread threadNum = new Thread(printNum, "打印数字线程");
        Thread threadLetter = new Thread(printLetter, "打印字母线程");

        threadNum.start();
        threadLetter.start();
    }
}
