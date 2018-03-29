import java.util.ArrayList;

public class MyClass {
    public static void test() {
        try {
            new ArrayList<Object>().get(0);
        }
        catch (IndexOutOfBoundsException ae) {
            System.out.println("TRUUUU");
        }
    }
//    public static void main(String[] args) {
//        test();
//    }
}
