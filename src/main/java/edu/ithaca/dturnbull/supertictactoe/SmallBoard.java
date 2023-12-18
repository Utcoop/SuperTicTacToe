package edu.ithaca.dturnbull.supertictactoe;

public class SmallBoard {
    int[][] board;
    int ownedBy;
    boolean won;

    public SmallBoard() {
        board = new int[3][3];
        ownedBy = -1;
        won = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = -1;
            }
        }
    }

    /**
     * 
     * @param row    of board
     * @param col    of board
     * @param player that takes the board. Player 1 is 0, Player 2 is 1.
     * @returns the next board.
     */
    public int[][] fillSmallBoardSection(int row, int col, int player) {
        if (board[row][col] == -1) {
            board[row][col] = player;
        } else {
            System.out.println("That section has been taken");
        }
        return board;
    }

    /**
     * 
     * @return the board initialized by this instance of the SmallBoard class
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * 
     * @return check to see if the board has been won or not
     */
    public boolean checkSmallBoardWin() {
        ownedBy = BoardHandler.checkWin(board);
        return (ownedBy == 0 || ownedBy == 1);
    }

    /**
     * 
     * @return who has won the board
     */
    public int getOwner() {
        return ownedBy;
    }

    /**
     * 
     * @return that the board has been won or not
     */
    public boolean getWon() {
        return won;
    }

    public String toStringSmallBoard() {
        String temp = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2) {
                    temp += board[i][j] + "\n";
                } else {
                    temp += board[i][j] + " | ";
                }
            }
            if (i != 2) {
                temp += "---|----|---\n";
            }
        }
        return temp;
    }
}
