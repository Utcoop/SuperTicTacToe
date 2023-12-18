package edu.ithaca.dturnbull.supertictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PlayerTest {

    /**
     * Checks to see if a player taking thier turn fills the same location as expected
     * and that the next new current board is as expected.
     */
    
    @Test
    void takeTurnTest(){
        Player player = new Player();
        LargeBoard board = new LargeBoard();
        player.takeTurn(1,1,0);
        board.getBoardSection(1, 1).fillSmallBoardSection(1, 1, 0);
        assertEquals(player.toStringMainBoard(), board.toStringLargeBoard());
        player.takeTurn(1,2,0);
        board.getBoardSection(1, 1).fillSmallBoardSection(1, 2, 0);
        assertEquals(player.toStringMainBoard(), board.toStringLargeBoard());
        player.takeTurn(1,2,0);
        board.getBoardSection(1, 2).fillSmallBoardSection(1, 2, 0);
        assertEquals(player.toStringMainBoard(), board.toStringLargeBoard());
    }

    /**
     * Checks to see if the new board is assigned correctly.
     */
    @Test
    void nextBoardTest(){
        Player player = new Player();
        LargeBoard board = new LargeBoard();
        player.takeTurn(0, 0, 0);
        board.getBoardSection(1, 1).fillSmallBoardSection(0,0,0);
        assertEquals(player.toStringCurrentBoard(), board.getBoardSection(0, 0).toStringSmallBoard());
        player.takeTurn(2, 2, 0);
        board.getBoardSection(0, 0).fillSmallBoardSection(2,2,0);
        assertEquals(player.toStringCurrentBoard(), board.getBoardSection(2, 2).toStringSmallBoard());
    }

    //Unsure how to test this currently. Need a UI potentially.
    /*@Test
    void quitTest(){
        
    }
    */
    /**
     * checks reset by making multiple moves and calling reset to see if is the same as an instance of large board
     */
    @Test
    void resetTest(){
        Player player = new Player();
        LargeBoard board = new LargeBoard();
        player.takeTurn(0, 0, 0);
        player.takeTurn(2, 2, 0);
        player.takeTurn(1,1,0);
        player.takeTurn(1, 2, 0);
        player.reset();
        assertEquals(player.toStringMainBoard(), board.toStringLargeBoard());
    }

    /**
     * Checks to see if two different instances of the player class have different boards
     * and Checks to see if both player's boards are the same.
     */
    @Test
    void getLargeTest(){
        //
        Player player = new Player();
        Player player1 = new Player();
        assertNotSame(player.getLargeBoard(), player1.getLargeBoard());
        assertEquals(player.toStringMainBoard(), player1.toStringMainBoard());
        assertEquals(player.toStringMainBoard(), player.getLargeBoard().toStringLargeBoard());
    }

    /**
     * This tests simply returns the board being used by the player class.
     */
    @Test
    void getCurrentBoardTest(){
        Player player = new Player();
        assertSame(player.getCurrentBoard(), player.getLargeBoard().getBoardSection(1,1));
    }

    /**
     * This is the integration test for my exam. I chose this as it uses all
     * implemented methods in order show an example of a game that was won. This
     * game in particular ends much faster than a real game of Super Tic Tac Toe
     * would in a normal instance. Once the game is over we reset.
     */
    @Test
    void toStringTest() {
        Player player = new Player();
        System.out.println(player.toStringMainBoard());
        System.out.println(player.toStringScoreBoard());
        // Player 1 wins the top right board. Player 2 Enables it.
        player.takeTurn(0, 2, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(0, 2, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(1, 2, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(0, 2, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(2, 2, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(0, 2, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(2, 1, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(0, 2, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(2, 0, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        assertTrue(player.getLargeBoard().getBoardSection(0, 2).checkSmallBoardWin());
        System.out.println(player.toStringMainBoard());
        System.out.println(player.toStringScoreBoard());
        // Player 1 wins the top middle board. Player 2 Enables it.
        player.takeTurn(0, 1, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(2, 2, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(0, 1, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(2, 1, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(0, 1, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(2, 0, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        assertTrue(player.getLargeBoard().getBoardSection(0, 1).checkSmallBoardWin());
        System.out.println(player.toStringMainBoard());
        System.out.println(player.toStringScoreBoard());
        // Player 1 wins the top left board. Player 2 Enables it.
        player.takeTurn(0, 0, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(2, 2, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(0, 0, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(2, 1, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(0, 0, player.getCurrentPlayer());
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        player.takeTurn(2, 0, player.getCurrentPlayer());
        assertTrue(player.getLargeBoard().getBoardSection(0, 0).checkSmallBoardWin());
        assertTrue(player.getLargeBoard().checkLargeBoardWin());
        System.out.println(player.toStringMainBoard());
        System.out.println(player.toStringScoreBoard());
        // Resets the board folowing the win. Checks if it actually resets.
        player.reset();
        assertFalse(player.getLargeBoard().checkLargeBoardWin());
        System.out.println(player.toStringMainBoard());
        System.out.println(player.toStringScoreBoard());
    }
}
