public class Launcher {

    public ConsoleUI gui = new ConsoleUI();

    public void play() {
        gui.message("Welcome to Sudoku.\n");
        gui.askSize();
        try {
            while (gui.board.isSolved();) {
                gui.options();
            }
            gui.message("\nPuzzle Solved!");
        }
        catch ()

    }

    public static void main(String[] args) {
        new Launcher().play();
    }

}
