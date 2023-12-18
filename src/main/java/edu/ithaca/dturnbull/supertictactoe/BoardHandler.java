package edu.ithaca.dturnbull.supertictactoe;

public class BoardHandler {
  /**
   * @param board itereated over and used to check to see if there is either
   *              3 of one symbol in a row or, in the case of a full board with no
   *              three in a row, checks for a majority ownership of the total
   *              board.
   * @return the number of the playher who obtained 3 in a row.
   */
  public static int checkWin(int[][] board) {
    if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] >= 0) {
      return board[0][0];
    } else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] >= 0) {
      return board[1][0];
    } else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] >= 0) {
      return board[2][0];
    } else if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] >= 0) {
      return board[0][0];
    } else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] >= 0) {
      return board[0][1];
    } else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] >= 0) {
      return board[0][2];
    } else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] >= 0) {
      return board[0][0];
    } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] >= 0) {
      return board[0][2];
    } else {
      return tieBreak(board);
    }
  }

  /**
   * 
   * @param board Checks to see if board is fully filled or not. If it is, it
   *              returns the
   *              player that has majority spaces. If it isn't it returns -1,
   *              indicating the board has not one.
   * @return
   */
  public static int tieBreak(int[][] board) {
    int count0 = 0;
    int count1 = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == 0) {
          count0++;
        } else if (board[i][j] == 1) {
          count1++;
        } else {
          return -1;
        }
      }
    }
    if (count0 > count1) {
      return 0;
    } else {
      return 1;
    }
  }
}
