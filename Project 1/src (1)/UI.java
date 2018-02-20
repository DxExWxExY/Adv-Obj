import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    private InputStream in;
    private OutputStream out;

    public UI() {
        this(System.in, System.out);
    }

    public UI(InputStream in, PrintStream out) {
        in = System.in;
        out = System.out;
    }
    public void welcome() {
        System.out.print("Welcome to Sudoku!");
    }

    public int askSize() {
        try {
            System.out.print("\nPlease Select the Board Size. \nEnter 1 for 4x4 Grid or 2 for 9x9 Grid: ");
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    System.out.print("Selected Size is 4x4 ");
                    return 4;
                case 2:
                    System.out.print("Selected Size is 9x9 ");
                    return 9;
                default :
                    System.out.print("Select Option 1 or 2 ");
                    break;
            }
            return askSize();
        }
        catch (InputMismatchException e1) {
            System.out.print("Error: Please Enter a Number");
            return askSize();
        }

    }

    public void message(String s) {
        System.out.print(s);
    }
}
