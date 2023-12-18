package edu.ithaca.dturnbull.supertictactoe;

public class LargeBoard {
    SmallBoard[][] board;
    boolean won;
    int[][] scoreBoard;
    int ownedBy;

    /**
     * LargeBoard constructor. Makes a 2D array of SmallBoard called Board
     * and a Scoreboard that represents the won sections of Board.
     * Populates Board with instances of small board and populates
     * scoreBoard with -1 which represent unclaimed board sections.
     * Sets won to false and owned by to -1.
     */
    public LargeBoard() {
        board = new SmallBoard[3][3];
        scoreBoard = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new SmallBoard();
                scoreBoard[i][j] = -1;
            }
        }
        won = false;
        ownedBy = -1;
    }

    /**
     * 
     * @param row    to be filled
     * @param col    to be filled
     * @param player who won the section
     */
    public int[][] fillScoreBoardSection(int row, int col, int player) {
        if (scoreBoard[row][col] == -1) {
            scoreBoard[row][col] = player;
            checkLargeBoardWin();
        } else {
            System.out.println("This should never be reached");
        }
        return scoreBoard;
    }

    /**
     * 
     * @return checks to see if the large board has been won
     */
    public boolean checkLargeBoardWin() {
        ownedBy = BoardHandler.checkWin(scoreBoard);
        return (ownedBy != -1);
    }

    /**
     * 
     * @return a section of the large board
     */
    public SmallBoard getBoardSection(int row, int col) {
        return board[row][col];
    }

    /**
     * 
     * @return the game board
     */
    public SmallBoard[][] getBoard() {
        return board;
    }

    /**
     * 
     * @return the scoreboard
     */
    public int[][] getScoreBoard() {
        return scoreBoard;
    }

    /**
     * 
     * @return a string that represents the full boardstate of the game
     */
    public String toStringScoreBoard() {
        String temp = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2) {
                    temp += scoreBoard[i][j] + "\n";
                } else {
                    temp += scoreBoard[i][j] + " | ";
                }
            }
            if (i != 2) {
                temp += "---|----|---\n";
            }
        }
        return temp;
    }

    /**
     * 
     * @return a string that represents the full boardstate of the game
     */
    public String toStringLargeBoard() {
        String temp = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    temp += board[i][0].getBoard()[j][k] + " | ";
                }
                for (int k = 0; k < 3; k++) {
                    temp += board[i][1].getBoard()[j][k] + " | ";
                }
                for (int k = 0; k < 3; k++) {
                    if (k == 2) {
                        temp += board[i][2].getBoard()[j][k] + "\n";
                        if (j != 2) {
                            temp += "- - - - - - -|- - - - - - - |- - - - - - -  \n";
                        }
                    } else {
                        temp += board[i][2].getBoard()[j][k] + " | ";
                    }
                }
            }
            if (i != 2) {
                temp += "-------------|--------------|-------------\n";
            }
        }
        return temp;
    }

    /**
     * 
     * @return True if the board has been won indicating the game is over, or false indicating 
     * it is not over yet.
     */
    public Boolean getWon(){
        return won;
    }
}
