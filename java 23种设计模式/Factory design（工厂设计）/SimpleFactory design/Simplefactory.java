import java.util.Scanner;

interface Computer {
    void print();
}

class Macpro implements Computer {
    public void print() {
        System.out.println("This is a Macpro with bar");
    }

}

class Surface implements Computer {
    public void print() {
        System.out.println("This is a Surface");
    }
}

class VailWare implements Computer {
    public void print() {
        System.out.println("This is a VailWare");
    }
}

class Factory {
    public static Computer make(String name) {

        if (name.equals("mac")) {
            Computer computer = new Macpro();
            return computer;
        } else if (name.equals("surfae")) {
            Computer computer = new Surface();
            return computer;
        }
        return new 
    }
}

public class Simplefactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Computer computer = Factory.make(str);
        computer.print();
        scanner.close();
    }
}