public class TestSwitch {
    public static void main(String[] args) throws Exception {
        System.out.println("请输入字符");
        char x = (char) System.in.read();
        switch (x) {
        case 'a': {
            System.out.println("我是猪");
            break;
        }
        case 'b': {
            System.out.println("我不是猪");
            break;
        }
        default: {
            System.out.println("我真的不是猪");
            break;
        }

        }
    }
}