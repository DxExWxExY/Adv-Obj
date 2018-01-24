public class Board {

    private int size;
    private int[][] board;

    Board(int size) {
        this.size = size;
        this.board = new int[size][size];
    }

    public boolean getRange(int num) {
        return num <= size && num > 0;
    }

    public int getBoardSize() {
        return size;
    }

    public int getBoardElement(int i, int j) {
        return board[i][j];
    }

    public void setBoardElement(int row, int col, int num) {
        board[row][col] = num;
    }

    public void removeBoardElement(int row, int col) {
        board[row][col] = 0;
    }

    public boolean checkHorizontal(int row, int num) {
        if (num == 0) {
            return true;
        }
        for (int i = 0; i < size; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    public boolean checkVertical(int col, int num) {
        if (num == 0) {
            return true;
        }
        for (int i = 0; i < size; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSubGrid(int row, int col, int num) {
        if (num == 0) {
            return true;
        }
        int rowStart = (int) (row - (row % Math.sqrt(size)));
        int colStart = (int) (col - (col % Math.sqrt(size)));
        int rowEnd = (int) (rowStart + (Math.sqrt(size)));
        int colEnd = (int) (colStart + (Math.sqrt(size)));
        for (; rowStart <= rowEnd; rowStart++) {
            for (; colStart < colEnd; colStart++) {
                if (board[rowStart][colStart] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSolved() {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (board[y][x] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void test() {
        if (size == 4) {
            board = new int[][]{{1, 2, 4, 3},
                    {3, 4, 2, 1},
                    {4, 3, 1, 2},
                    {1, 1, 3, 0}};
        }
    }
}
