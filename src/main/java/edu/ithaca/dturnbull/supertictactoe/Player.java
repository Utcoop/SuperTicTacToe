package edu.ithaca.dturnbull.supertictactoe;

public class Player {
    LargeBoard mainBoard;
    SmallBoard currentBoard;
    int cbRow, cbCol;
    int currentPlayer;
    TurnHandler handler;

    /**
     * Player Constructor has no parameters and begins as Player 1, which
     * is represented by 0. Player two is represented by 1.
     */
    public Player() {
        mainBoard = new LargeBoard();
        currentBoard = mainBoard.getBoardSection(1, 1);
        cbRow = 1;
        cbCol = 1;
        handler = new TurnHandler(mainBoard);
        currentPlayer = 0;
    }

    /**
     * 
     * @param row of the board to play in
     * @param col column of the board to play in
     * @return the instance of SmallBoard that the next player must play in
     */
    public SmallBoard takeTurn(int row, int col, int player) {
        currentBoard.fillSmallBoardSection(row, col, player);
        if (currentBoard.checkSmallBoardWin()){
            mainBoard.fillScoreBoardSection(cbRow, cbCol, player);
        }
        currentBoard = nextBoard(row, col);
        cbRow = row;
        cbCol = col;
        if (currentPlayer == 0) {
            currentPlayer = 1;
        } else {
            currentPlayer = 0;
        }
        return currentBoard;
    }

    /**
     * 
     * @param row row of the next board
     * @param col column of the next board 
     * @return the next instance of small board that will be the new current board
     */
    public SmallBoard nextBoard(int row, int col) {
        return handler.nextBoard(row, col);
    }

    /**
     * Quits the game.
     */
    public void quit() {
        System.exit(0);
    }

    /**
     * Resets the game reusing the methods of the constructor
     */
    public void reset() {
        mainBoard = new LargeBoard();
        currentBoard = mainBoard.getBoardSection(1, 1);
        cbRow = 1;
        cbCol = 1;
        handler = new TurnHandler(mainBoard);
        currentPlayer = 0;
    }

    /**
     * 
     * @return integer that represents the row of the current board in the main board
     */
    public int getcbRow(){
        return cbRow;
    }

    /**
     * 
     * @return integer that represents the column of the current board in the main board
     */
    public int getcbCol(){
        return cbCol;
    }

    /**
     * Gets the LargeBoard
     * 
     * @return SmallBoard[][]
     */
    public LargeBoard getLargeBoard() {
        return mainBoard;
    }

    /**
     * 
     * @return the current board
     */
    public SmallBoard getCurrentBoard() {
        return currentBoard;
    }

    /**
     * 
     * @return the int that represents the currentPlayer
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * 
     * @return a string that represents the main board
     */
    public String toStringMainBoard() {
        return mainBoard.toStringLargeBoard();
    }

    /**
     * 
     * @return returns a string that represents the score on the large board
     */
    public String toStringScoreBoard() {
        return mainBoard.toStringScoreBoard();
    }

    /**
     * 
     * @return returns a string that represents the current board
     */
    public String toStringCurrentBoard(){
        return currentBoard.toStringSmallBoard();
    }
}
