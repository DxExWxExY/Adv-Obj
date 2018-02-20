public class Runner {

    private UI ui = new UI();
    private Board board;

    public static void main(String[] args) {
        new Runner().play();
    }
    public void play() {
        ui.welcome();
        int size = ui.askSize();
        board = new Board(size);
        board.size = ui.askSize();

        while (!board.isSolved()) {

        }
        ui.message("Solved!");
    }

}
