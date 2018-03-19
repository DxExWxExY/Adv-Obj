import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testBoard1() {
        assertEquals(9, board.size()); // default size
    }

    @Test
    public void testBoard2() {
        board = new Board(4);
        assertEquals(4, board.size()); //created board of size 4
    }

    @Test
    public void testValidity() {
        board = new Board(4);
        board.setElement(3, 3, 9);
        /*determine if 9 is allowed in a 4x4*/
        assertEquals(false, board.isValid(3, 3));
    }

    @Test
    public void testInsertion() {
        board = new Board(4);
        board.setElement(3, 3, 1);
        /*determine if the number was inserted correctly*/
        assertEquals(1, board.getElement(3,3));
    }

    @Test
    public void testSubgridInsertion() {
        board = new Board(4);
        board.setElement(0,0,1);
        board.setElement(0,1,2);
        board.setElement(1,0,3);
        board.setElement(1,1,4);
        board.setElement(0,2,4);
        /*determine if the correct subgrid was checked*/
        assertEquals(true, board.isValid(0,2));
    }

    @Test
    public void testVertical() {
        board = new Board(4);
        board.setElement(0,0,1);
        board.setElement(3,0,1);
        /*the vertical insertion of 1 is not valid*/
        assertEquals(false, board.isValid(3,0));
        board.setElement(3,0,2);
        /*the vertical insertion of 2 is valid*/
        assertEquals(true, board.isValid(3,0));
    }

    @Test
    public void testHorizontal() {
        board = new Board(4);
        board.setElement(0,0,1);
        board.setElement(0,3,1);
        /*the vertical insertion of 1 is not valid*/
        assertEquals(false, board.isValid(0,3));
        board.setElement(0,3,2);
        /*the vertical insertion of 2 is valid*/
        assertEquals(true, board.isValid(0,3));

    }

    @Test
    public void testCompleted() {
        board = new Board(4);
        board.test();
        board.setElement(3,3,4);
        /*determines is the game is solved*/
        assertEquals(true, board.isSolved());
    }
}
