package edu.ithaca.dturnbull.supertictactoe;

public class FullSmallBoardException extends RuntimeException {
    public FullSmallBoardException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
