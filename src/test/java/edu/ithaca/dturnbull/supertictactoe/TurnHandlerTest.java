package edu.ithaca.dturnbull.supertictactoe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TurnHandlerTest {
    /**
     * Fills a spot on a board section at row 1, column 2. Checks to see if nextBoard gives us 
     *  that board by comparing the two string output of that and a function that we know will give us the correct board
     */
    @Test
    void nextBoardTest() {
        Player player = new Player();
        player.getLargeBoard().getBoardSection(1,2).fillSmallBoardSection(1, 1, 0);
        assertEquals(player.getLargeBoard().getBoardSection(1, 2).toStringSmallBoard(), player.nextBoard(1, 2).toStringSmallBoard());
    }
}
