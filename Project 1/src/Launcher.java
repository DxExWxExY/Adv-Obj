public class Launcher {

    private ConsoleUI gui = new ConsoleUI();

    private void play() {
        try {
            gui.message("Welcome to Sudoku.\n");
            gui.askSize();
            while (!gui.board.isSolved()) {
                gui.options();
            }
            gui.message("\nPuzzle Solved!");
        }
        /*this catches a purposely thrown exception
        * to end the game*/
        catch (StackOverflowError a) {
            gui.message("\nDone.");
        }
    }

    public static void main(String[] args) {
        new Launcher().play();
    }

}
