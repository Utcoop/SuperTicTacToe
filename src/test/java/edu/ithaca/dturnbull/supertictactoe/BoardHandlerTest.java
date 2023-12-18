package edu.ithaca.dturnbull.supertictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class BoardHandlerTest {

    /**
     * All tests in this class check one of each of the eight ways to win to see if each works.
     */

    @Test
    void winCheckTest1() {
        SmallBoard board = new SmallBoard();
        board.fillSmallBoardSection(0, 0, 0);
        board.fillSmallBoardSection(1, 1, 0);
        board.fillSmallBoardSection(2, 2, 0);
        assertEquals(0, BoardHandler.checkWin(board.getBoard()));
        System.out.println(board.toStringSmallBoard());
    }

    @Test
    void winCheckTest2() {
        SmallBoard board = new SmallBoard();
        board.fillSmallBoardSection(0, 2, 0);
        board.fillSmallBoardSection(1, 1, 0);
        board.fillSmallBoardSection(2, 0, 0);
        assertEquals(0, BoardHandler.checkWin(board.getBoard()));
        System.out.println(board.toStringSmallBoard());
    }

    @Test
    void winCheckTest3() {
        SmallBoard board = new SmallBoard();
        board.fillSmallBoardSection(0, 0, 0);
        board.fillSmallBoardSection(1, 0, 0);
        board.fillSmallBoardSection(2, 0, 0);
        assertEquals(0, BoardHandler.checkWin(board.getBoard()));
        System.out.println(board.toStringSmallBoard());
    }

    @Test
    void winCheckTest4() {
        SmallBoard board = new SmallBoard();
        board.fillSmallBoardSection(0, 1, 0);
        board.fillSmallBoardSection(1, 1, 0);
        board.fillSmallBoardSection(2, 1, 0);
        assertEquals(0, BoardHandler.checkWin(board.getBoard()));
        System.out.println(board.toStringSmallBoard());
    }

    @Test
    void winCheckTest5() {
        SmallBoard board = new SmallBoard();
        board.fillSmallBoardSection(0, 2, 0);
        board.fillSmallBoardSection(1, 2, 0);
        board.fillSmallBoardSection(2, 2, 0);
        assertEquals(0, BoardHandler.checkWin(board.getBoard()));
        System.out.println(board.toStringSmallBoard());
    }

    @Test
    void winCheckTest6() {
        SmallBoard board = new SmallBoard();
        board.fillSmallBoardSection(0, 0, 0);
        board.fillSmallBoardSection(0, 1, 0);
        board.fillSmallBoardSection(0, 2, 0);
        assertEquals(0, BoardHandler.checkWin(board.getBoard()));
        System.out.println(board.toStringSmallBoard());
    }

    @Test
    void winCheckTest7() {
        SmallBoard board = new SmallBoard();
        board.fillSmallBoardSection(1, 0, 0);
        board.fillSmallBoardSection(1, 1, 0);
        board.fillSmallBoardSection(1, 2, 0);
        assertEquals(0, BoardHandler.checkWin(board.getBoard()));
        System.out.println(board.toStringSmallBoard());
    }

    @Test
    void winCheckTest8() {
        SmallBoard board = new SmallBoard();
        board.fillSmallBoardSection(2, 0, 0);
        board.fillSmallBoardSection(2, 1, 0);
        board.fillSmallBoardSection(2, 2, 0);
        assertEquals(0, BoardHandler.checkWin(board.getBoard()));
        System.out.println(board.toStringSmallBoard());
    }

    
    /**
     * Checks to see if no one has wone yet.
     */
    @Test
    void winCheckTest9() {
        SmallBoard board = new SmallBoard();
        assertEquals(-1, BoardHandler.checkWin(board.getBoard()));
        System.out.println(board.toStringSmallBoard());
    }

    /**
     * Checks to see if ties are broken properly
     */
    @Test
    void winCheckTieBreak(){
        SmallBoard board = new SmallBoard();
        board.fillSmallBoardSection(2, 0, 0);
        board.fillSmallBoardSection(2, 1, 1);
        board.fillSmallBoardSection(2, 2, 0);
        board.fillSmallBoardSection(1, 0, 1);
        board.fillSmallBoardSection(1, 1, 1);
        board.fillSmallBoardSection(1, 2, 0);
        board.fillSmallBoardSection(0, 0, 0);
        board.fillSmallBoardSection(0, 1, 0);
        board.fillSmallBoardSection(0, 2, 1);
        assertEquals(0, BoardHandler.checkWin(board.getBoard()));
    }
}
