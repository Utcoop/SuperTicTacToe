package edu.ithaca.dturnbull.supertictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SmallBoardTest {

    @Test
    public void fillSectionTest(){
        //TODO
        //This is tested in player test
    }

    @Test
    public void getBoardTest(){
        //TODO
        //This is tested in player test
    }

    @Test
    public void checkWinTest(){
        //TODO
        //This is tested in player test
    }

    /**
     * Checks to see if owner updates when a board is won.
     */
    @Test
    public void getOwnerTest(){
        SmallBoard board = new SmallBoard();
        board.fillSmallBoardSection(0, 0, 0);
        board.fillSmallBoardSection(0, 1, 0);
        board.fillSmallBoardSection(0, 2, 0);
        board.checkSmallBoardWin();
        assertEquals(0, board.getOwner());
    }

}
