import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {

    public Board board;
    private Scanner in = new Scanner(System.in);
    private PrintStream out = System.out;

    public void askSize() {
        try {
            out.print("\nPlease Select a Grid Size.\nEnter (1) for 4x4 Grid or (2) for 9x9 Grid or (0) to Quit: ");
            switch (in.nextInt()) {
                case 1:
                    out.print("Selected Grid 4x4.");
                    board = new Board(4);
                    drawGrid4x4();
                    return;
                case 2:
                    out.print("Selected Grid 9x9.");
                    board = new Board(9);
                    drawGrid9x9();
                    return;
                case 9:
                    out.print("Entered Test Mode.");
                    board = new Board(4);
                    board.test();
                    drawGrid4x4();
                    return;
                case 0:
                    out.print("Exiting Game.");
                    throw new StackOverflowError();
                default:
                    out.print("Error: Please Enter a Valid Option.");
                    askSize();
                    break;
            }
        }
        catch (InputMismatchException a) {
            out.print("\nError: Please Enter a Number.");
            in.next();
            askSize();
        }
    }

    private void drawGrid4x4() {
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                out.print("\n    1   2    3   4" +
                                "\n  ╔═══╦═══╦╦═══╦═══╗\n");
            }
            out.print((i+1)+" ║ "+board.getBoardElement(i,0)+" ║ "+board.getBoardElement(i,1)
                    +" ║║ "+board.getBoardElement(i,2)+" ║ "+board.getBoardElement(i,3)+" ║");
            if (i != 3) {
                out.print("\n  ╠═══╬═══╬╬═══╬═══╣\n");
            }
            if (i == 1) {
                out.print("  ╠═══╬═══╬╬═══╬═══╣\n");
            }
            if (i == 3) {
                out.print("\n  ╚═══╩═══╩╩═══╩═══╝");
            }
        }
    }

    private void drawGrid9x9() {
        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                out.print("\n    1   2    3   4   5   6    7   8   9\n" +
                        "  ╔═══╦═══╦═══╦╦═══╦═══╦═══╦╦═══╦═══╦═══╗\n");
            }
            out.print((i+1)+" ║ "+board.getBoardElement(i,0)+" ║ "+board.getBoardElement(i,1)+" ║ "+board.getBoardElement(i,2)+" ║║ "
                                +board.getBoardElement(i,3)+" ║ "+board.getBoardElement(i,4)+" ║ "+board.getBoardElement(i,5)+" ║║ "
                                +board.getBoardElement(i,6)+" ║ "+board.getBoardElement(i,7)+" ║ "+board.getBoardElement(i,8)+" ║");
            if (i != 8) {
                out.print("\n  ╠═══╬═══╬═══╬╬═══╬═══╬═══╬╬═══╬═══╬═══╣\n");
            }
            if (i == 2 || i == 5) {
                out.print("  ╠═══╬═══╬═══╬╬═══╬═══╬═══╬╬═══╬═══╬═══╣\n");
            }
            if (i == 8) {
                out.print("\n  ╚═══╩═══╩═══╩╩═══╩═══╩═══╩╩═══╩═══╩═══╝");
            }
        }
    }

    private void insertNumber() {
        try {
            out.print("\nInsert Number.");
            out.print("\nEnter Row: ");
            int row = in.nextInt();
            out.print("Enter Column: ");
            int col = in.nextInt();
            out.print("Enter Number: ");
            int num = in.nextInt();
            if (board.checkHorizontal(row-1, num) && board.checkVertical(col-1, num)
                    && board.getRange(num) && board.checkSubGrid(row-1, col-1, num)) {
                board.setBoardElement(row-1, col-1, num);
                out.print("Number Inserted.\n");
                if (board.getBoardSize() == 4) {
                    drawGrid4x4();
                }
                if (board.getBoardSize() == 9) {
                    drawGrid9x9();
                }
            }
            else {
                out.print("Could not Insert Number.");
                if (!board.checkHorizontal(row-1, num)) {
                    out.print("\nNumber not Allowed Horizontally.");
                }
                if (!board.checkVertical(col-1, num)) {
                    out.print("\nNumber not Allowed Vertically.");
                }
                if (!board.checkSubGrid(row-1, col-1, num)) {
                    out.print("\nNumber is in the Sub-Grid.");
                }
                if (!board.getRange(num)) {
                    out.print("\nNumber is out of Range.");
                }
            }
        }
        catch (InputMismatchException a) {
            out.print("\nPlease Enter a Number.");
            insertNumber();
        }
        catch (IndexOutOfBoundsException b) {
            out.print("\nOut of Range, Try Again.");
            insertNumber();
        }
    }

    private void removeNumber() {
        out.print("\nDelete Number.");
        out.print("\nEnter Row: ");
        int row = in.nextInt();
        out.print("Column: ");
        int col = in.nextInt();
        if (row-1 < board.getBoardSize() && col-1 < board.getBoardSize()) {
            board.removeBoardElement(row-1, col-1);
            out.print("Number Deleted.\n");
            if (board.getBoardSize() == 4) {
                drawGrid4x4();
            }
            if (board.getBoardSize() == 9) {
                drawGrid9x9();
            }
        }
    }

    public void message(String s) {
        out.print(s);
    }

    public void options() {
        try {
            out.print("\nInsert Number or Delete Number.\nEnter (1) for Insertion or (2) for Deletion or (0) to Quit: ");
            switch (in.nextInt()) {
                case 1:
                    insertNumber();
                    return;
                case 2:
                    removeNumber();
                    return;
                case 0:
                    out.print("\nExiting Game.");
                    throw new StackOverflowError();
                default:
                    out.print("\nError: Enter a Valid Option.");
            }
        }
        catch (InputMismatchException a) {
            out.print("\nError: Please Enter a Number.");
            in.next();
            options();
        }
    }
}
