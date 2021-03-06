public class Board {

    private int size;
    private int[][] board;

    /*constructor that sets the size*/
    Board(int size) {
        this.size = size;
        this.board = new int[size][size];
    }

    /*this tells if the input number is in range*/
    public boolean getRange(int num) {
        return num <= size && num > 0;
    }

    /*this returns the value of the variable size*/
    public int getBoardSize() {
        return size;
    }

    /*this  method retrieves the element at position i,j*/
    public int getBoardElement(int i, int j) {
        return board[i][j];
    }

    /*this stores n into the position i,j*/
    public void setBoardElement(int row, int col, int num) {
        board[row][col] = num;
    }

    /*this sets the element at position i,j back to 0*/
    public void removeBoardElement(int row, int col) {
        board[row][col] = 0;
    }

    /*this performs the horizontal check*/
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

    /*this performs the vertical line check*/
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

    /*this checks the sub grid*/
    public boolean checkSubGrid(int row, int col, int num) {
        if (num == 0) { // if the element to replace is 0
            return true;
        }
        /*the starting position is determined by modding the
        * row/col num by the sqrt of the size*/
        int rowStart = (int) (row - (row % Math.sqrt(size)));
        int colStart = (int) (col - (col % Math.sqrt(size)));
        int rowEnd = (int) (rowStart + (Math.sqrt(size)));
        int colEnd = (int) (colStart + (Math.sqrt(size)));
        for (; rowStart <= rowEnd; rowStart++) {
            for (; colStart < colEnd; colStart++) {
                if (board[rowStart][colStart] == num) {
                    return false; //if a matching number is found
                }
            }
        }
        return true;
    }

    /*this checks if there are any 0's left in the matrix*/
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

    /*special method to test isSolved method, it fill a 4x4
    * matrix with a pre-solved matrix missing the last element
    * at row 4 col 4*/
    public void test() {
        this.size = 4;
        board = new int[][]{{1, 2, 4, 3},
                {3, 4, 2, 1},
                {4, 3, 1, 2},
                {1, 1, 3, 0}};
    }
}
