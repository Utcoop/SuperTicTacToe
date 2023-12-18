package edu.ithaca.dturnbull.supertictactoe;

public class TurnHandler {
    LargeBoard mainBoard;

    public TurnHandler(LargeBoard board) {
        mainBoard = board;
    }

    /**
     * 
     * @param row of the next small board
     * @param col of the next small board
     * @return the new board;
     */
    public SmallBoard nextBoard(int row, int col) {
        SmallBoard temp = mainBoard.getBoard()[row][col];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (temp.getBoard()[i][j] == -1) {
                    return temp;
                }
            }
        }
        throw new FullSmallBoardException("This board is full", null);
    }

    public SmallBoard goAnywhere(int row, int col) {
        return nextBoard(row, col);
    }
}
